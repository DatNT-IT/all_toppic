package com.example.FIS_project_training.dao.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;

public class DBConnect {
    public static Connection getConnection() throws Exception {
        Connection con = ds.getConnection();
        return con;
    }

    private static HikariDataSource ds;
    private static HikariConfig config = new HikariConfig("/datasource.properties");

    static {
        ds = new HikariDataSource(config);
    }
}
