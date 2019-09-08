package com.springasync.demo.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springasync.demo.domain.User;
import com.springasync.demo.service.MainService;

@RestController
public class UserController {

	private MainService mainService;

	public UserController(MainService mainService) {
		this.mainService = mainService;
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> processUser(@RequestBody User user){
		System.out.println("Got it before: "+ user);
		return mainService.processIt(user);
	}
	
	@GetMapping("/user/{phone}")
	public ResponseEntity<User> getUser(@PathVariable String phone) throws InterruptedException, ExecutionException{
		System.out.println("Got it before: "+ phone);
		return mainService.getUser(phone);
	}
}
