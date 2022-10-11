package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;
import com.util.ComponentTest;

@RestController    //@Controller+@RequestBody.
@RequestMapping("/user")
public class UserController {
	
	

	@Autowired
	UserService userService;
	ComponentTest compTest;
	
	@GetMapping("/login")
	public String login(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		System.out.println("user name"+username+" password "+password);
		
		boolean flag = userService.verifyUserCredentials(username,password);
		if(flag) {
			return "You are logged in successfully!!!!";
		}
		
		return "Your user name and password is incorrect please try again!!";
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> saveUser(@RequestBody User user ) {
		
		User user1 = userService.saveUserRecord(user);
		
		return new ResponseEntity<User>(user1, HttpStatus.OK);
	}
	
	@GetMapping("/getdata")
	public  ResponseEntity<List<User>> GetAlldata(){
			
		List<User> list = userService.getAllCustomers();
			return new ResponseEntity<List<User>>(list , HttpStatus.ACCEPTED);
		}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteData(@PathVariable ("id") int id ){
		
		boolean flag=userService.DeleteDataById(id);
		if(flag) {
		return new ResponseEntity<String>("you have been successfully deleted", HttpStatus.OK);
		}	
		return new ResponseEntity<String>("you could not delete User due to some network issue.", HttpStatus.OK);

	}
	@PutMapping("/update/{userid}")
	public  ResponseEntity<String> updateData(@PathVariable("userid") int userid , @RequestBody User user){
		User updateduser= userService.getUser(userid, user);
		
		if(null != updateduser ) {
			return new ResponseEntity<String>("User Updated Successfully..!", HttpStatus.ACCEPTED);
		}else {
		return new ResponseEntity<String>("User can not Updated !", HttpStatus.ACCEPTED);
		}
	}
	
	@PutMapping("/updatedata")
	public void update2nd(@RequestBody User user) {
		userService.updateUserbyId(user);
	//ComponentTest comptest = new ComponentTest();
	//	comptest.callInController();
			
		}
		
}


