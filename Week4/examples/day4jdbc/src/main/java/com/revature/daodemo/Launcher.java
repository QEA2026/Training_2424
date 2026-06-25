package com.revature.daodemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Launcher {
    public static void main(String[] args) throws SQLException
            {
        String url = "jdbc:sqlite:week4_jdbc_dao_demo.db";

        try (Connection conn = DriverManager.getConnection(url)) {

            //open database connection
            try (Statement st = conn.createStatement()) {

                st.executeUpdate("DROP TABLE IF EXISTS product");

                st.executeUpdate("""
                    CREATE TABLE product (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        sku TEXT NOT NULL UNIQUE,
                        name TEXT NOT NULL,
                        price REAL NOT NULL
                    )

                    """);
            }
        }
    }
}
