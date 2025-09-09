package vn.iostar.models;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String email;
    private String username;
    private String fullname;
    private String password;
    private int roleId;
    private String phone;

    public User() {}

    public User(String email, String username, String fullname, String password,
                 int roleId, String phone) {
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.roleId = roleId;
        this.phone = phone;
    }

    // Getters và Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}
}
