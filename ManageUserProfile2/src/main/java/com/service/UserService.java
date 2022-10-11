package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	//boolean CheckCrendentials(String username, String password);

	boolean verifyUserCredentials(String username, String password);

	User saveUserRecord(User user);

	List<User> getAllCustomers();

	boolean DeleteDataById(int id);

	User getUser(int userid, User user);

	void updateUserbyId(User user);

}
