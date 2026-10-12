package com.school.ui;

import com.school.dao.UserDao;
import com.school.model.User;

import java.util.Optional;
import java.util.Scanner;

/**
 * Main menu: Register, Login, Exit.
 */
public class MainMenu {

    private final Scanner scanner;
    private final UserDao userDao;

    public MainMenu(Scanner scanner, UserDao userDao) {
        this.scanner = scanner;
        this.userDao = userDao;
    }

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("===== MAIN MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            switch (scanner.nextLine().trim()) {
                case "1" -> register();
                case "2" -> login();
                case "3" -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }
        }
    }

    private void register() {
        System.out.println();
        System.out.println("--- Register Account ---");

        String username = prompt("Username: ");
        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }
        String password = prompt("Password: ");
        if (password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        String role = null;
        while (role == null) {
            System.out.println("Role: 1. TEACHER  2. STUDENT");
            switch (prompt("Choose role: ")) {
                case "1" -> role = "TEACHER";
                case "2" -> role = "STUDENT";
                default -> System.out.println("Invalid role. Enter 1 or 2.");
            }
        }

        if (userDao.register(username, password, role)) {
            System.out.println("Registered! Your account status is PENDING until approved.");
        } else {
            System.out.println("That username is already taken.");
        }
    }

    private void login() {
        System.out.println();
        System.out.println("--- Login ---");
        String username = prompt("Username: ");
        String password = prompt("Password: ");

        Optional<User> user = userDao.login(username, password);
        if (user.isPresent()) {
            new UserMenu(scanner, user.get()).show();
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private String prompt(String label) {
        System.out.print(label);
        return scanner.nextLine().trim();
    }
}
