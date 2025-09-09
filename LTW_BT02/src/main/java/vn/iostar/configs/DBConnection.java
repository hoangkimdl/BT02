package vn.iostar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String serverName = "localhost";
    private static final String dbName = "LTWEB";
    private static final String portNumber = "1433";
    private static final String instance = ""; // Nếu có instance thì điền vào, ví dụ: "SQLEXPRESS"
    private static final String userID = "sa";
    private static final String password = "1";

    public static Connection getConnection() throws Exception {
        String url;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=false;trustServerCertificate=true";
        } else {
            url = "jdbc:sqlserver://" + serverName + "\\" + instance + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=false;trustServerCertificate=true";
        }

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
}
