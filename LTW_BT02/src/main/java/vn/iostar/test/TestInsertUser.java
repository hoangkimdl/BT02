package vn.iostar.test;

import vn.iostar.configs.DBConnection;
import java.sql.*;

public class TestInsertUser {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            System.out.println("Kết nối thành công tới: " + conn.getCatalog());

            // Thử insert
            String sql = "INSERT INTO users(username, password, email, fullname, roleid, phone) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "testuser");
                ps.setString(2, "123456");
                ps.setString(3, "test@mail.com");
                ps.setString(4, "Người Test");
                ps.setInt(5, 2);
                ps.setString(6, "0123456789");

                int rows = ps.executeUpdate();
                System.out.println("Insert row = " + rows);
            }

            // Thử select lại
            String query = "SELECT TOP 5 * FROM users ORDER BY id DESC";
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("username") + " | " +
                        rs.getString("email")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
