package com.sebastian.gamelibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeedData {
    public static void main(String[] args){
        try (Connection conn = DatabaseConnection.connect()) {
            String gameSql ="INSERT INTO games (title, release_year, rating) VALUES (?, ?, ?)";
            PreparedStatement gameStmt = conn.prepareStatement(gameSql);
            gameStmt.setString(1, "Silksong");
            gameStmt.setInt(2, 2025);
            gameStmt.setDouble(3, 9.2);
            gameStmt.addBatch();

            gameStmt.setString(1, "Elden Ring");
            gameStmt.setInt(2, 2022);
            gameStmt.setDouble(3, 9.5);
            gameStmt.addBatch();

            gameStmt.executeBatch();

            String[] genres = {"RPG", "Action", "Horror", "MMORPG"};
            String genreSQL = "INSERT INTO genres (name) VALUES (?)";
            PreparedStatement genreStmt = conn.prepareStatement(genreSQL);
            for (String genre : genres) {
                genreStmt.setString(1, genre);
                genreStmt.addBatch();
            }
            genreStmt.executeBatch();

            String[] platforms = {"Xbox", "PC", "Playstation", "Nintendo"};
            String platformSQL = "INSERT INTO platforms (name) VALUES (?)";
            PreparedStatement platformStmt = conn.prepareStatement(platformSQL);
            for (String platform : platforms) {
                platformStmt.setString(1, platform);
                platformStmt.addBatch();
            }

            platformStmt.executeBatch();

            System.out.println("Data seeded successfully!");
        } catch (SQLException e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }
}
