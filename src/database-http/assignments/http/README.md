# HTTP Methods and Employee REST API

`EmployeeApiRequests.http` shows the endpoint design and example requests
for all five methods. It uses IntelliJ's built-in HTTP Client format.

## Endpoint contract

Base URL: `http://localhost:8080`

| Method and path | Purpose | Successful status |
|---|---|---:|
| `GET /api/employees` | List employees | `200 OK` |
| `GET /api/employees/{id}` | Get one employee | `200 OK` |
| `POST /api/employees` | Create an employee | `201 Created` |
| `PUT /api/employees/{id}` | Replace all employee fields | `200 OK` or `204 No Content` |
| `PATCH /api/employees/{id}` | Update only supplied fields | `200 OK` or `204 No Content` |
| `DELETE /api/employees/{id}` | Delete an employee | `204 No Content` |

An API commonly returns `400 Bad Request` for invalid input, `404 Not Found`
when an ID does not exist, and `409 Conflict` for a duplicate email.

## Send requests

1. Open `EmployeeApiRequests.http` in IntelliJ.
2. Ensure an API server is running at `localhost:8080` and implements the
   endpoints above.
3. Click the green run arrow beside a request.

This project does not yet include a web server implementing these endpoints.
The `.http` file is the client request exercise/API contract, not a server;
the requests will fail to connect until a server is started.

The file creates an employee before the update/delete examples and stores its
ID in an HTTP Client variable. If the server does not support that feature,
run requests individually and replace `{{employeeId}}` with a real ID.
Names, email, and salary are sample values.
