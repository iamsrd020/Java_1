USE jdbc_demo;

-- Assignment 7: create the referenced table before the employees table.
CREATE TABLE IF NOT EXISTS departments (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE
) ENGINE = InnoDB;

INSERT IGNORE INTO departments (id, name) VALUES
    (1, 'Engineering'),
    (2, 'Finance'),
    (3, 'Customer Support');

-- Assignments 1 and 6: columns plus PRIMARY KEY, UNIQUE, NOT NULL,
-- DEFAULT, CHECK, and FOREIGN KEY constraints.
-- department_id is nullable so LEFT JOIN can show unassigned employees.
CREATE TABLE IF NOT EXISTS employees (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    salary DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    department_id INT NULL,
    CONSTRAINT chk_employees_salary CHECK (salary >= 0),
    CONSTRAINT fk_employees_department
        FOREIGN KEY (department_id) REFERENCES departments(id)
) ENGINE = InnoDB;

-- Assignment 2: insert five employees.
-- Rahul has no department so INNER JOIN and LEFT JOIN demonstrate
-- the difference between dropping and preserving unmatched employees.
INSERT INTO employees (id, name, email, salary, department_id) VALUES
    (1, 'Darshan', 'darshan@example.test', 60000.00, 1),
    (2, 'Harshitha', 'harshitha@example.test', 72000.00, 1),
    (3, 'Rahul', 'rahul@example.test', 55000.00, NULL),
    (4, 'Priya', 'priya@example.test', 68000.00, 3),
    (5, 'Sai', 'sai@example.test', 50000.00, NULL);

-- Assignment 3: update one employee. WHERE limits the change to id 3.
UPDATE employees
SET salary = 58000.00
WHERE id = 3;

-- Assignment 4: delete one employee. Check the id before running this line.
DELETE FROM employees
WHERE id = 5;

-- Assignment 5: retrieve every employee and all requested fields.
SELECT id, name, email, salary, department_id
FROM employees
ORDER BY id;

-- Assignment 8: calculate summary values over the remaining employees.
SELECT
    COUNT(*) AS total_employees,
    SUM(salary) AS total_salary,
    AVG(salary) AS average_salary,
    MAX(salary) AS highest_salary,
    MIN(salary) AS lowest_salary
FROM employees;

-- Assignment 9: INNER JOIN includes employees with a matching department.
SELECT e.name AS employee_name, d.name AS department_name
FROM employees AS e
INNER JOIN departments AS d ON d.id = e.department_id
ORDER BY e.id;

-- Assignment 10: LEFT JOIN preserves all employees. A missing department
-- appears as NULL. Rahul remains in this result even though he has no department.
SELECT e.name AS employee_name, d.name AS department_name
FROM employees AS e
LEFT JOIN departments AS d ON d.id = e.department_id
ORDER BY e.id;

-- Assignment 11: commit a demonstration INSERT so it remains in the table.
START TRANSACTION;

INSERT INTO employees (id, name, email, salary, department_id)
VALUES (6, 'Commit Demo', 'commit.demo@example.test', 40000.00, 2);

COMMIT;

-- Assignment 12: change a salary, inspect if desired, then undo that change.
START TRANSACTION;

UPDATE employees
SET salary = salary + 1000.00
WHERE id = 6;

-- Optional: inspect the uncommitted value before rolling back.
SELECT id, name, salary FROM employees WHERE id = 6;

ROLLBACK;

-- The salary is back to 40000.00 because the update was rolled back.
SELECT id, name, salary FROM employees WHERE id = 6;

-- Final check after the committed insert and rolled-back update.
SELECT id, name, email, salary, department_id
FROM employees
ORDER BY id;
