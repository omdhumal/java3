package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public boolean verifyUserCredentials(String username, String password) {
	
		
		User user = userRepository.getByCustomeremail(username);
		
		if(user != null && user.getCustomerpassword().equals(password)) {
			return true;
		}
		
		return false;
		
	}

	@Override
	public User saveUserRecord(User user) {
		
		User user1=userRepository.save(user);
		return user1;
	}

	@Override
	public List<User> getAllCustomers() {
		List<User> list =userRepository.findAll();
		return list;
	}

	@Override
	public boolean DeleteDataById(int id) {
		try {
		userRepository.deleteById(id);
		return true;
		}catch(Exception e){
			return false;
			
		}
	}

	@Override
	public User getUser(int userId, User user) {
		User user1=userRepository.getById(userId);
		user1.setCustomername(user.getCustomername());
		user1.setCustomeremail(user.getCustomeremail());
		user1.setCustomerpassword(user.getCustomerpassword());
		user1.setCustomergender(user.getCustomergender());
		user1.setCustomercountry(user.getCustomercountry());
		user1.setContactno(user.getContactno());
		
		return userRepository.save(user1);
		
	}

	@Override
	public void updateUserbyId(User user) {
		userRepository.UpdateByid (user.getCustomername(),user.getContactno(),user.getCustomerid());
		
	}

}
