package com.sebastian.gamelibrary;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueriesTest {

    @Test
    public void games_hasCorrectCount() throws SQLException {
        try (Connection conn = DatabaseConnection.connect()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM games");
            rs.next(); //necessary in order to move to the first or only row
            int count = rs.getInt(1); //JDBC positions start at 1, not 0
            assertEquals(2, count);
        }
    }
}
