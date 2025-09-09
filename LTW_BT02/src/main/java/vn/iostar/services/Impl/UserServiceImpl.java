package vn.iostar.services.Impl;

import vn.iostar.models.User;
import vn.iostar.services.UserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.iostar.configs.DBConnection;
import vn.iostar.dao.UserDao;
import vn.iostar.dao.Impl.UserDaoImpl;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);   // ✅ gọi sang DAO
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);    // ✅ gọi sang DAO
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.checkExistUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.checkExistPhone(phone);
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        try {
            if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email) || userDao.checkExistPhone(phone)) {
                return false;
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setFullname(fullname);
            user.setPhone(phone);
            user.setRoleId(2);

            userDao.insert(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        try {
            userDao.updatePassword(username, newPassword);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findByEmail(String email) {
    	  String sql = "SELECT * FROM users WHERE email = ?";
    	    try (Connection conn = DBConnection.getConnection();
    	         PreparedStatement ps = conn.prepareStatement(sql)) {
    	        ps.setString(1, email);
    	        ResultSet rs = ps.executeQuery();
    	        if (rs.next()) {
    	            User user = new User();
    	            user.setId(rs.getInt("id"));
    	            user.setUsername(rs.getString("username"));
    	            user.setPassword(rs.getString("password"));
    	            user.setFullname(rs.getString("fullname"));
    	            user.setRoleId(rs.getInt("roleid"));
    	            user.setEmail(rs.getString("email"));
    	            return user;
    	        }
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	    }
    	    return null;
    }

}
