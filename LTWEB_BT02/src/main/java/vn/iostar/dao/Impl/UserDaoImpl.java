package vn.iostar.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iostar.configs.DBConnection;
import vn.iostar.dao.UserDao;
import vn.iostar.models.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User get(String username) {
        String sql = "SELECT * FROM users WHERE username = ?"; // chú ý tên bảng
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("username"));
                    user.setFullName(rs.getString("fullname"));
                    user.setPassWord(rs.getString("password"));
                    user.setRoleid(rs.getInt("roleid"));
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
