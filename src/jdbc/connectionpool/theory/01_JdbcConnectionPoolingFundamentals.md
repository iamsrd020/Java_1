# 1. JDBC Connection Pooling

## First, what is a database connection?

JDBC is Java's standard API for talking to relational databases. A JDBC
`Connection` represents a session between a Java application and a database.
The application can use it to run SQL, commit or roll back transactions, and
read results.

Opening a real database connection is relatively expensive. The driver and
database may need to establish a network connection, authenticate a user,
allocate server resources, and initialize session state. If an application
opens a brand-new connection for every small database operation, that setup
cost is repeatedly paid.

## The pool analogy

Imagine a library with ten study desks:

- A request arriving to study is like an application task needing a database
  connection.
- The pool is the desk manager.
- Checking out a connection is like getting a desk.
- Finishing database work and calling `close()` is like returning the desk.
- If every desk is occupied, the next person waits for one to become free.

A **connection pool** creates and keeps a limited number of physical database
connections ready for reuse. Application code borrows one, performs its work,
then returns it to the pool.

```text
Application
    -> DataSource / connection pool
    -> borrow a connection
    -> execute database work
    -> close the borrowed connection (return it to the pool)
```

## Physical versus borrowed connection

The pool owns the real, physical connection to the database. The application
usually receives a logical/proxy `Connection` representing a temporary
checkout. With a pooled `DataSource`, calling `connection.close()` normally
returns that checkout to the pool; it does **not** shut down the physical
database connection.

This is why `close()` is still essential. If code forgets to close the
borrowed connection, the pool cannot safely lend it to another request. The
connection stays checked out, and the pool can become exhausted.

Use try-with-resources so the connection is returned even when an exception
happens:

```java
try (Connection connection = dataSource.getConnection();
     PreparedStatement statement = connection.prepareStatement(
             "SELECT name FROM employee WHERE id = ?")) {
    statement.setInt(1, employeeId);
    try (ResultSet result = statement.executeQuery()) {
        while (result.next()) {
            System.out.println(result.getString("name"));
        }
    }
}
```

With a pool-backed `DataSource`, the outer `close()` returns the connection
to the pool. The result set and statement are also closed. In real
applications, use prepared statements for values supplied by users.

## What happens when a request arrives?

1. The application asks the `DataSource` for a connection.
2. The pool gives it an idle connection, creating one if allowed and needed.
3. If the pool has reached its maximum and all connections are checked out,
   the request waits for one to be returned.
4. If it waits longer than the configured connection timeout, acquisition
   fails with an exception.
5. The application executes its database work and commits or rolls back as
   required.
6. The application closes the borrowed connection, which returns it to the
   pool for another request.

The exact pool behavior depends on its configuration. A request does not
receive a busy connection that another request is already using.

## Pooling versus opening a connection every time

**Without pooling:** each operation opens a physical database connection and
closes it afterward. This can be adequate for a tiny script or a very
low-volume program, but repeated setup adds latency and database overhead.

**With pooling:** a bounded set of physical connections is reused. This
reduces repeated connection setup and limits how many simultaneous database
sessions the application opens. Pooling is commonly important for web
applications that serve many requests.

Pooling does not make a slow SQL query fast. It reduces connection creation
overhead and manages concurrent access to a limited database resource.

## How ten connections can serve one hundred requests

A pool with ten connections allows up to ten requests to hold connections at
the same time. If one hundred requests need the database:

1. Up to ten borrow connections.
2. The other requests wait in the pool while those connections are busy.
3. When a request finishes and closes its connection, that connection goes
   back to the pool.
4. A waiting request can then borrow it.
5. This repeats until all requests finish.

The pool is not serving one hundred simultaneous database operations with
only ten connections. It is **reusing** ten connections over time and
limiting database concurrency. If work is slow, the queue can grow and
requests can time out.

## What if all connections are busy?

The pool does not create unlimited connections or hand out a connection that
is already in use. A new borrower waits up to the configured acquisition
timeout. If another borrower returns a connection in time, it is reused; if
not, the pool reports a timeout/failure.

Common causes include:

- requests are running long queries or holding transactions open too long;
- application code did not close connections, statements, or result sets;
- the pool is smaller than the legitimate database workload needs;
- the application is sending more concurrent work than the database can
  handle.

Increasing the pool size is not always the answer. Too many connections can
overload the database and make response times worse. First investigate query
duration, transaction boundaries, and connection leaks.

## HikariCP

**HikariCP** is a popular, lightweight JDBC connection-pool library. It
provides a `DataSource` that application code can use to borrow and return
connections. It is commonly used in Spring Boot applications and can also be
configured directly in other Java applications.

A simplified direct configuration looks like this (requires the HikariCP
library and a JDBC driver on the classpath):

```java
HikariConfig config = new HikariConfig();
config.setJdbcUrl("jdbc:postgresql://localhost:5432/company");
config.setUsername("app_user");
config.setPassword("read-this-from-configuration");
config.setMaximumPoolSize(10);

try (HikariDataSource dataSource = new HikariDataSource(config);
     Connection connection = dataSource.getConnection()) {
    // Use the connection for database work.
}
```

Do not put real passwords in source code. Load credentials from secure
configuration. In a Spring Boot application, HikariCP is commonly selected
and configured through application properties when the relevant dependencies
are present.

The small assignments in this project do not add HikariCP or a database
dependency. They model the concepts only; the code above is an illustration,
not a class that can run in this project as-is.

For a first real connection without a pool, the project also includes
`assignments/Assignment09RealDatabaseConnection`. It uses JDBC's
`DriverManager` directly with MySQL Connector/J, creates a small sample
banking schema (`bank_customers` and `bank_accounts`), inserts 20 fictional
named customers with accounts, reads account data back, and closes the
connection with try-with-resources.
Contact details are reserved examples; it is for JDBC practice only, not a
real banking system. Follow the setup and verification steps in
`assignments/README.md`.

## Important pool settings and habits

- **Maximum pool size:** upper bound on physical connections in the pool.
- **Connection/acquisition timeout:** how long a borrower waits for a
  connection before failing.
- **Minimum idle:** how many idle connections the pool tries to keep ready
  (depending on pool configuration).
- **Connection lifetime/idle timeout:** controls how long connections remain
  in the pool; exact semantics are pool-specific.
- **Close every borrowed connection:** use try-with-resources.
- **Keep transactions short:** do not hold a connection while doing unrelated
  slow work.
- **Size the pool for the database:** account for all application instances,
  not only one process.
- **Monitor wait time and active/idle counts:** saturation and leaks should
  be investigated rather than hidden by arbitrary size increases.

## Quick answers to the mini assignments

1. With three idle connections and three simultaneous requests, each request
   can borrow a different connection. The exact assignment order is not
   important.
2. Pooling is generally better for frequently used, high-traffic
   applications because it reuses physical connections and bounds database
   sessions.
3. `Application -> Connection Pool -> Get Connection -> DB Operation ->
   Return Connection to Pool`.
4. The third request waits for a connection up to the configured timeout. It
   gets a returned connection or fails if the wait expires.
5. `Application -> Connection Pool/DataSource -> Database Operation ->
   Close/return connection to pool`.
6. Pooling avoids repeatedly paying connection setup costs and limits
   concurrent database sessions.
7. HikariCP is a JDBC connection-pool library, commonly used with Spring Boot
   and other Java applications.
8. Ten requests can use the ten connections first; the remaining requests
   wait and reuse connections as earlier requests return them.
