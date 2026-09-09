package com.sebastian.gamelibrary;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SchemaSetup {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.connect()){
            String sql = Files.readString(Paths.get("schema.sql"));
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Schema created successfully!");
        } catch (SQLException | IOException e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }
}