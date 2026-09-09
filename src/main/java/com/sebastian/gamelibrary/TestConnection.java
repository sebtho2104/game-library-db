package com.sebastian.gamelibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/game_library";
        String user = "postgres";
        String password = "passord123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Tilkobling vellykket!");
        } catch (SQLException e) {
            System.out.println("Tilkobling feilet: " + e.getMessage());
        }
    }
}