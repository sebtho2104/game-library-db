package com.sebastian.gamelibrary;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Queries {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.connect()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT games.title, genres.name FROM games JOIN games_genres ON games.id = games_genres.game_id JOIN genres ON games_genres.genre_id = genres.id"
            );

            while (rs.next()) {
                System.out.println(rs.getString("title") + " - " + rs.getString("name"));
            }

        } catch (SQLException e) {
            System.out.println(("Failed: " + e.getMessage()));
        }
    }
}
