# User System

A console app (Java 17 + Maven + SQLite) with Register, Login, and Logout/Exit.

## Structure

```
src/main/java/com/school/
├── Main.java                  # entry point
├── model/User.java            # record: id, username, password, roles, status
├── dao/DatabaseConnection.java# SQLite connection + users table creation
├── dao/UserDao.java           # register / login (PreparedStatement)
└── ui/MainMenu.java, UserMenu.java
```

## Run

```
mvn compile exec:java
```

The `users.db` file is created automatically on first run.

## Features

- Register with role TEACHER or STUDENT; status defaults to PENDING
- Login checks username and password against the database
- Logout returns to the main menu; Exit closes the app
