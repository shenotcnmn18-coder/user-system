package com.school;

import com.school.dao.DatabaseConnection;
import com.school.dao.UserDao;
import com.school.ui.MainMenu;

import java.util.Scanner;

/**
 * App entry point.
 */
public class Main {

    public static void main(String[] args) {
        DatabaseConnection.initialize();

        try (Scanner scanner = new Scanner(System.in)) {
            new MainMenu(scanner, new UserDao()).show();
        }
    }
}
