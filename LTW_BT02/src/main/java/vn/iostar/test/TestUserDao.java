package vn.iostar.test;

import vn.iostar.dao.Impl.UserDaoImpl;
import vn.iostar.models.User;

public class TestUserDao {
    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoImpl();

        // Thay username, password bằng dữ liệu thật trong bảng users
        String username = "employee";
        String password = "456";

        User user = dao.login(username, password);

        if (user != null) {
            System.out.println("✅ Tìm thấy user:");
            System.out.println("ID: " + user.getUserId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Fullname: " + user.getFullname());
            System.out.println("RoleId: " + user.getRoleId());
        } else {
            System.out.println("❌ Không tìm thấy user với username/password này!");
        }
    }
}
