
package com.waldomilanes.invoice.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author waldo-ana
 */
public class DBUtil {

    private static final String USER = "web";
    private static final String PASS = "";
    private static final String CONN_MY
            = "jdbc:mysql://localhost/explorecalifornia";
    private static final String CONN_MY_L
            = "jdbc:mysql://localhost/explorecalifornia";
    private static final String USER_P = "postgres";
    private static final String PASS_P = "8689";
    private static final String CONN_P
            = "jdbc:postgresql://localhost:5433/postgres";
    private static final String PASS_P_I = "itla";
    private static final String CONN_P_I
            = "jdbc:postgresql://localhost:5432/postgres";

    public static Connection getConnection(DBType db) throws SQLException {

        switch (db) {
            case MYSQL:
                return DriverManager.getConnection(CONN_MY, USER, PASS);
            case POSTGRESQL:
                return DriverManager.getConnection(CONN_P, USER_P, PASS_P);
            case ITLA:
                return DriverManager.getConnection(CONN_P_I, USER_P, PASS_P);
            case LYNDA:
                return DriverManager.getConnection(CONN_MY_L, USER, PASS);
            default:
                return null;
        }

    }

    public static void processException(SQLException e) {
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL state: " + e.getSQLState());
    }




}
