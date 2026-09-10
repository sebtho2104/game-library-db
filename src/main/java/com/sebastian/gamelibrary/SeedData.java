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
            String genreSql = "INSERT INTO genres (name) VALUES (?)";
            PreparedStatement genreStmt = conn.prepareStatement(genreSql);
            for (String genre : genres) {
                genreStmt.setString(1, genre);
                genreStmt.addBatch();
            }
            genreStmt.executeBatch();

            String[] platforms = {"Xbox", "PC", "Playstation", "Nintendo"};
            String platformSql = "INSERT INTO platforms (name) VALUES (?)";
            PreparedStatement platformStmt = conn.prepareStatement(platformSql);
            for (String platform : platforms) {
                platformStmt.setString(1, platform);
                platformStmt.addBatch();
            }

            platformStmt.executeBatch();

            String gamesGenreSql = "INSERT INTO games_genres (game_id, genre_id) VALUES (?, ?)";
            PreparedStatement gamesGenreStmt = conn.prepareStatement(gamesGenreSql);

            gamesGenreStmt.setInt(1, 1); // Silksong
            gamesGenreStmt.setInt(2, 2); // Action
            gamesGenreStmt.addBatch();

            gamesGenreStmt.setInt(1, 2); // Elden Ring
            gamesGenreStmt.setInt(2, 1); // RPG
            gamesGenreStmt.addBatch();

            gamesGenreStmt.setInt(1, 2); // Elden Ring
            gamesGenreStmt.setInt(2, 2); // Action
            gamesGenreStmt.addBatch();

            gamesGenreStmt.executeBatch();

            String gamePlatformSql = "INSERT INTO games_platforms (game_id, platform_id) VALUES (?, ?)";
            PreparedStatement gamePlatformStmt = conn.prepareStatement(gamePlatformSql);

            gamePlatformStmt.setInt(1, 1); // Silksong
            gamePlatformStmt.setInt(2, 4); // Nintendo
            gamePlatformStmt.addBatch();

            gamePlatformStmt.setInt(1, 2); // Elden Ring
            gamePlatformStmt.setInt(2, 2); // PC
            gamePlatformStmt.addBatch();

            gamePlatformStmt.executeBatch();

            System.out.println("Data seeded successfully!");
        } catch (SQLException e) {
            System.out.println("Failed: " + e.getMessage());
        }
    }
}
