package com.springasync.demo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springasync.demo.domain.User;

@Service
public class MainService {

	private UserService userService;

	@Autowired
	public MainService(UserService userService) {
		this.userService = userService;
	}
	
	
	public ResponseEntity<User> processIt(User user){
		System.out.println("Got it now before: "+ user);
		userService.processIt(user);
		System.out.println("Got it now: "+ user);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<User> getUser(String phone) throws InterruptedException, ExecutionException{
		System.out.println("Got it now before: "+ phone);
		User user = userService.futureProcessIt(phone);
		System.out.println("Got it now: "+ user);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
	
}
