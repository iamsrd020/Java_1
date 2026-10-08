# JDBC Connection Pooling Assignments

Assignments 1-8 are small runnable explanations or simulations in the
`jdbc.connectionpool.assignments` package. Assignment 9 establishes a real
JDBC connection to MySQL and requires a running MySQL server and MySQL
Connector/J driver.

| Class | Topic |
|---|---|
| `Assignment01ConnectionReuse` | Assign three requests to three idle connections |
| `Assignment02PoolingVsNoPooling` | Compare pooling with opening a new connection per request |
| `Assignment03ConnectionPoolFlow` | Complete the pool-based flow |
| `Assignment04AllConnectionsBusy` | Explain what happens when the pool is exhausted |
| `Assignment05BasicFlow` | Complete the basic application/database flow |
| `Assignment06WhyPoolingMatters` | Explain pooling in high-traffic applications |
| `Assignment07HikariCP` | Describe HikariCP and common usage |
| `Assignment08OneHundredRequests` | Simulate 100 requests sharing 10 connections |
| `Assignment09RealDatabaseConnection` | Connect to MySQL, create customer/account tables, add 20 named sample records, and display account balances |

Compile from the project root:

```text
javac -encoding UTF-8 -d out src/jdbc/connectionpool/assignments/*.java
```

Run a class, for example:

```text
java -cp out jdbc.connectionpool.assignments.Assignment08OneHundredRequests
```

## Install MySQL and the JDBC driver

JDBC is included in the JDK; you do not install JDBC separately. To connect
to MySQL, you need a running MySQL Server and its JDBC driver, **MySQL
Connector/J**.

1. Install MySQL Server and start it. You can also install MySQL Workbench to
   run SQL commands with a graphical interface.
2. Create the example database using Workbench or the MySQL command line:

   ```sql
   CREATE DATABASE jdbc_demo;
   ```

3. Download **MySQL Connector/J** from the official MySQL website. Choose the
   Platform Independent archive, extract it, and locate the file named like
   `mysql-connector-j-<version>.jar`.
4. Add that JAR to IntelliJ's runtime classpath: open **File > Project
   Structure > Modules > Dependencies**, click **+**, choose **JARs or
   directories**, select the Connector/J JAR, and apply the change.

## Configure and run the connection

The project-root `.env` file is already created with example settings:

```text
JDBC_URL=jdbc:mysql://localhost:3306/jdbc_demo
DB_USERNAME=root
DB_PASSWORD=CHANGE_ME
```

Replace `CHANGE_ME` with the password for your local MySQL account. If your
account has no password, leave the value empty. The `.env` file is ignored by
Git so your local password is not committed. `.env.example` is a safe
template. Environment variables with the same names take priority over the
file.

In IntelliJ, run
`jdbc.connectionpool.assignments.Assignment09RealDatabaseConnection`.
Ensure the run configuration's **Working directory** is the project root,
because that is where the program looks for `.env`. It creates
`bank_customers` and `bank_accounts` if needed, inserts 20 named sample
customers and their accounts, displays the account balances, and closes the
connection automatically. Names include Darshan, Harshitha, Rahul, and
others. Contact details use reserved `.example.test` addresses and
placeholder phone numbers, not real personal data. Re-running updates these
sample IDs with the current sample data. The inserts run in one transaction;
if a database error occurs, the sample inserts are rolled back. This is
sample learning data, not a real banking system.

To verify the table yourself in the MySQL command line, select the database
and inspect the schema and records:

```sql
USE jdbc_demo;
DESCRIBE bank_customers;
DESCRIBE bank_accounts;

SELECT * FROM bank_customers;
SELECT * FROM bank_accounts;
SELECT COUNT(*) AS customer_count FROM bank_customers;
```

To see account owners and balances together:

```sql
SELECT a.account_id, c.full_name, a.account_type, a.balance
FROM bank_accounts AS a
JOIN bank_customers AS c ON c.customer_id = a.customer_id;
```

If you ran an earlier version of the example, its `employees` table is left
untouched. This updated program no longer creates or uses it. An
`bank_transactions` table and its rows from the earlier version are also left
untouched, but the program no longer creates, inserts, or displays
transactions.

The Java source can be compiled without the driver because it uses only the
JDK's JDBC APIs, but running it requires both Connector/J and a reachable
MySQL server. Without them, connection setup fails with a clear configuration,
driver, or database error.
