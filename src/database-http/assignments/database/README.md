# Database SQL Assignments

`DatabaseAssignments.sql` completes all 12 database mini assignments using
MySQL and the separate `employee_db` database. It creates `departments` and `employees`,
adds five starting employees, demonstrates updates/deletes, aggregate
queries, joins, and transaction commit/rollback.

## Run it safely

This script creates and uses a separate database named `employee_db`; it
does not change the banking tables in `jdbc_demo`. It creates tables named
`departments` and `employees` there. If those tables already exist with a
different schema, stop and rename the tables before running the script. The
script does not drop tables. Sample employee IDs are inserted or updated so
you can rerun it to practice the exercises.

1. Open MySQL Command Line Client and enter your password.
2. The SQL script creates `employee_db` and switches to it. To select it
   manually when checking the results later, run:

   ```sql
   USE employee_db;
   ```

3. Open `DatabaseAssignments.sql` in IntelliJ or another editor. Copy and
   execute the script in the MySQL command line. You can also open it in
   MySQL Workbench if installed.
4. Read the comments in the script: it shows the purpose and expected effect
   of every SQL section.

The script commits a demonstration insert, then demonstrates that a later
salary update is undone by `ROLLBACK`. It ends by querying the final data.
It can be rerun on its sample tables; each run deliberately demonstrates an
update and a delete. Do not run it against important or production data.

The `CREATE TABLE` statements use current MySQL syntax and a `CHECK` on
salary. The tables use the InnoDB engine so foreign keys and transactions
work.
