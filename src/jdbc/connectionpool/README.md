# JDBC Connection Pooling

This topic is split into theory and runnable assignments:

```text
connectionpool/
|-- assignments/
|   |-- Assignment01ConnectionReuse.java
|   |-- Assignment02PoolingVsNoPooling.java
|   |-- Assignment03ConnectionPoolFlow.java
|   |-- Assignment04AllConnectionsBusy.java
|   |-- Assignment05BasicFlow.java
|   |-- Assignment06WhyPoolingMatters.java
|   |-- Assignment07HikariCP.java
|   |-- Assignment08OneHundredRequests.java
|   |-- Assignment09RealDatabaseConnection.java
|   `-- README.md
|-- theory/
|   `-- 01_JdbcConnectionPoolingFundamentals.md
`-- README.md
```

Read `theory/01_JdbcConnectionPoolingFundamentals.md` first. The assignments
are small, dependency-free explanations and simulations; they do not connect
to a real database. `Assignment09RealDatabaseConnection` is a live MySQL
example; its setup instructions are in `assignments/README.md`. The theory
also includes a HikariCP example for use when a database and the HikariCP
dependency are configured.

The project-root `.env` file holds local MySQL settings for the live
connection example. It is ignored by Git; replace its `CHANGE_ME` password
locally and follow the Connector/J setup in the assignments README.
