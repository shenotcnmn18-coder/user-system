package com.school.model;

/**
 * Immutable data model for a row in the users table.
 *
 * @param id       auto-generated primary key (0 for a user not yet saved)
 * @param username unique login name
 * @param password the password (see UserDao note about hashing)
 * @param roles    TEACHER or STUDENT
 * @param status   PENDING, APPROVED, ...
 */
public record User(int id, String username, String password, String roles, String status) {
}
