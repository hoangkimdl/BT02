package vn.iostar.services.impl;

import vn.iostar.dao.UserDao;
import vn.iostar.dao.Impl.UserDaoImpl;
import vn.iostar.models.User;
import vn.iostar.services.UserService;

public class UserServicesImpl implements UserService {

    // Khởi tạo DAO để dùng
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = userDao.get(username);
        if (user != null && user.getPassWord().equals(password)) {
            return user; // đúng user/pass
        }
        return null; // sai hoặc không tồn tại
    }

    @Override
    public User findByUsername(String username) {
        return userDao.get(username);
    }
}
