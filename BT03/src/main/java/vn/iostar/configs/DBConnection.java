package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String serverName = "localhost";
    private static final String dbName = "LTWEB";
    private static final String portNumber = "1433";
    private static final String instance = ""; 
    private static final String userID = "sa";
    private static final String password = "1";

    public static Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + (instance != null && !instance.trim().isEmpty() ? "\\" + instance : "")
                + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
}
