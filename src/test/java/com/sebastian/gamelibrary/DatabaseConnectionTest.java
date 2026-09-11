package com.sebastian.gamelibrary;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DatabaseConnectionTest {

    @Test
    public void connect_returnsValidConnection() throws SQLException {
        Connection conn = DatabaseConnection.connect();
        assertNotNull(conn);
        conn.close();
    }
}
