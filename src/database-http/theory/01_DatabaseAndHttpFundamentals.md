# Database and HTTP Fundamentals

This guide connects two ideas used by most web applications:

- A **database** stores information and lets us query or change it with SQL.
- **HTTP** is a protocol that lets a client and server exchange requests and
  responses over a network.

A typical application connects them:

```text
Browser / mobile app
        | HTTP request
        v
Java web application / REST API
        | SQL using JDBC
        v
MySQL database
        | query result
        v
Java web application -> HTTP response -> client
```

An API receives HTTP requests, uses application code and often SQL to do
work, then returns a response. HTTP and SQL are different languages for
different parts of the application: HTTP describes the client's request to
the server; SQL describes database operations.

## Part 1: Database and SQL

### Tables, rows, and columns

A relational database stores related information in **tables**:

- A **table** is like a spreadsheet for one type of thing.
- A **row** is one record, such as one employee.
- A **column** is one property, such as an employee's email address.

Example:

| id | name | email | salary | department_id |
|---:|---|---|---:|---:|
| 1 | Darshan | darshan@example.test | 60000.00 | 2 |

`id` identifies the row. `department_id` connects the employee row to a
department row.

### Creating tables and constraints

```sql
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    salary DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    department_id INT NULL,
    CHECK (salary >= 0),
    FOREIGN KEY (department_id) REFERENCES departments(id)
);
```

What the rules mean:

- **PRIMARY KEY:** uniquely identifies each row; it cannot be `NULL`.
- **UNIQUE:** prevents duplicate values, such as two employees using the same
  email address.
- **NOT NULL:** requires a value for that column.
- **DEFAULT:** supplies a value when an insert leaves the column out.
- **CHECK:** requires a condition to be true, here that salary is not
  negative. MySQL enforces check constraints in current supported versions.
- **FOREIGN KEY:** requires a non-null reference to match a row in the
  referenced table.

The employee's `department_id` is allowed to be `NULL` so an employee can
exist without an assigned department. A non-null department ID must exist in
`departments`.

### INSERT, SELECT, UPDATE, and DELETE

These are the basic data operations, often called CRUD:

```sql
-- Create a row
INSERT INTO employees (id, name, email, salary, department_id)
VALUES (1, 'Darshan', 'darshan@example.test', 60000.00, 2);

-- Read rows
SELECT id, name, email, salary
FROM employees
ORDER BY id;

-- Update selected rows
UPDATE employees
SET salary = 65000.00
WHERE id = 1;

-- Delete selected rows
DELETE FROM employees
WHERE id = 1;
```

Always think carefully about the `WHERE` clause in `UPDATE` and `DELETE`.
Without it, the statement changes or deletes every row in the table. It is
good practice to first run a `SELECT` with the same condition to confirm
which rows will be affected.

### Departments and relationships

One department can have many employees. This is a **one-to-many** relationship:

```text
departments.id  1 ------ many  employees.department_id
```

The foreign key is stored on the many side (`employees`). The key protects
referential integrity: it prevents an employee from referring to a
nonexistent department.

### Aggregate functions

An aggregate calculates one result from multiple rows:

```sql
SELECT
    COUNT(*) AS employee_count,
    SUM(salary) AS total_salary,
    AVG(salary) AS average_salary,
    MAX(salary) AS highest_salary,
    MIN(salary) AS lowest_salary
FROM employees;
```

- `COUNT(*)` counts rows.
- `SUM(salary)` adds salary values.
- `AVG(salary)` calculates their average.
- `MAX(salary)` and `MIN(salary)` find the largest and smallest values.

Aggregates other than `COUNT` usually ignore `NULL` values. The assignment
requires salary to be `NOT NULL`, so every employee contributes a salary.

### INNER JOIN and LEFT JOIN

A **JOIN** combines rows from related tables.

`INNER JOIN` returns only rows with a match on both sides:

```sql
SELECT e.name, d.name AS department_name
FROM employees AS e
INNER JOIN departments AS d ON d.id = e.department_id;
```

An employee without a department is omitted because there is no matching
department row.

`LEFT JOIN` returns every row from the left table and any matching row from
the right table:

```sql
SELECT e.name, d.name AS department_name
FROM employees AS e
LEFT JOIN departments AS d ON d.id = e.department_id;
```

All employees appear. For an employee with no department, `department_name`
is `NULL`. This is the important difference: `INNER JOIN` filters out
unmatched left rows, while `LEFT JOIN` preserves them.

### Transactions: COMMIT and ROLLBACK

A transaction groups database changes into one unit:

```sql
START TRANSACTION;

UPDATE employees
SET salary = salary + 1000
WHERE id = 1;

COMMIT;
```

`COMMIT` makes the transaction's changes permanent. To undo uncommitted
changes instead:

```sql
START TRANSACTION;

UPDATE employees
SET salary = salary + 1000
WHERE id = 1;

ROLLBACK;
```

After `ROLLBACK`, the database returns to the state from before that
transaction. A rollback cannot undo changes that have already been committed.
DDL such as `CREATE TABLE` may implicitly commit in MySQL, so table creation
is kept outside the transaction exercises.

Many command-line clients start with autocommit enabled, so each statement
may otherwise be committed immediately. Use `START TRANSACTION` explicitly
when practicing `COMMIT` and `ROLLBACK`.

## Part 2: HTTP and REST

### Request and response

An HTTP exchange has:

1. A **method** saying what action the client wants.
2. A **URL** identifying the resource.
3. Optional **headers**, which carry metadata such as content type.
4. An optional **body**, often JSON for create/update requests.
5. A **status code** and optional response body returned by the server.

Example:

```http
GET /api/employees/1 HTTP/1.1
Host: localhost:8080
Accept: application/json
```

Possible response:

```http
HTTP/1.1 200 OK
Content-Type: application/json

{"id":1,"name":"Darshan","email":"darshan@example.test","salary":60000.00}
```

### Resource URLs and REST

REST-style APIs model things as **resources**. Use nouns in paths:

```text
/api/employees       the employee collection
/api/employees/1     employee whose ID is 1
```

The HTTP method says what to do with that resource. A REST API is a design
style, not a special Java library or a separate protocol.

### The five methods in the assignment

| Method | Meaning | Typical request target | Safe? | Idempotent? |
|---|---|---|---|---|
| `GET` | Read a resource | `/api/employees` | Yes | Yes |
| `POST` | Create a resource or submit an action | `/api/employees` | No | Usually no |
| `PUT` | Replace a resource representation | `/api/employees/1` | No | Yes |
| `PATCH` | Partially update a resource | `/api/employees/1` | No | Depends on the patch |
| `DELETE` | Remove a resource | `/api/employees/1` | No | Yes |

**Safe** means the method is intended to read without changing server state.
**Idempotent** means repeating the same request has the same intended effect
as doing it once. For example, setting salary to exactly `65000` with `PUT`
does not keep increasing it each time.

`PUT` replaces the complete resource representation. `PATCH` changes only the
specified part. A patch body containing just salary should not erase the
employee's name or email.

### Example API contract

| Request | Purpose | Typical success status |
|---|---|---:|
| `GET /api/employees` | Return all employees | `200 OK` |
| `GET /api/employees/1` | Return employee 1 | `200 OK` |
| `POST /api/employees` | Create an employee | `201 Created` |
| `PUT /api/employees/1` | Replace employee 1 | `200 OK` with a body, or `204 No Content` |
| `PATCH /api/employees/1` | Update only supplied fields | `200 OK` with a body, or `204 No Content` |
| `DELETE /api/employees/1` | Delete employee 1 | `204 No Content` |

Useful non-success statuses include:

- `400 Bad Request`: malformed JSON or invalid field values.
- `404 Not Found`: the requested employee does not exist.
- `409 Conflict`: a duplicate unique value, such as an email already in use.
- `500 Internal Server Error`: unexpected server failure.

The exact success response can vary by API contract. For example, an API
could return `200` after DELETE with a response body, but `204` is common
when it returns no body.

### JSON request bodies

Create request:

```json
{
  "name": "Darshan",
  "email": "darshan@example.test",
  "salary": 60000.00,
  "departmentId": 2
}
```

Replace request (`PUT`): send the complete resource fields defined by the
API. Partial update (`PATCH`): send only the fields to change, for example:

```json
{
  "salary": 65000.00
}
```

For JSON requests, set `Content-Type: application/json`. A client can use
`Accept: application/json` to say it wants a JSON response.

## How the assignments fit together

The SQL exercises practice storing, validating, relating, querying, and
transactionally changing data. The HTTP exercises practice how a client asks
an API to read and change resources. In a real application, an API endpoint
may validate a request, execute SQL through JDBC, and convert the query
result into an HTTP response. The supplied HTTP request file demonstrates
the client side; it is not itself a running web server.
