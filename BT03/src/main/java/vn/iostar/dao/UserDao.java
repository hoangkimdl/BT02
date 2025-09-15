package vn.iostar.dao;

import vn.iostar.model.User;

public interface UserDao {
    void insert(User user);

    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);

    boolean checkExistEmail1(String email);
    boolean checkExistUsername1(String username);

    User login(String username, String password);
    User findByUsername(String username);
    void updatePassword(String username, String newPassword);
}
