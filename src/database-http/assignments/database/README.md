# Database SQL Assignments

`DatabaseAssignments.sql` completes all 12 database mini assignments using
MySQL and the `jdbc_demo` database. It creates `departments` and `employees`,
adds five starting employees, demonstrates updates/deletes, aggregate
queries, joins, and transaction commit/rollback.

## Run it safely

This script creates tables named `departments` and `employees` in
`jdbc_demo`. If you already have tables with those names, stop and choose a
different practice database or rename the tables in the script first. It
does not drop tables, but it is intended to be run once on fresh practice
tables. The sample IDs and emails must not already exist.

1. Open MySQL Command Line Client and enter your password.
2. Run:

   ```sql
   USE jdbc_demo;
   ```

3. Open `DatabaseAssignments.sql` in IntelliJ or another editor. Copy and
   execute the script in the MySQL command line. You can also open it in
   MySQL Workbench if installed.
4. Read the comments in the script: it shows the purpose and expected effect
   of every SQL section.

The script commits a demonstration insert, then demonstrates that a later
salary update is undone by `ROLLBACK`. It ends by querying the final data.
Do not run the script against important or production data.

The `CREATE TABLE` statements use current MySQL syntax and a `CHECK` on
salary. The tables use the InnoDB engine so foreign keys and transactions
work.
