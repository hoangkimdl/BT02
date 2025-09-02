package vn.iostar.services;

import vn.iostar.models.User;

public interface UserService {

	User login(String username, String password);
	User findByUsername(String username);
}
