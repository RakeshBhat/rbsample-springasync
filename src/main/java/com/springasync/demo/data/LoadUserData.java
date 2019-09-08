package com.springasync.demo.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springasync.demo.data.repository.UserRepository;
import com.springasync.demo.domain.User;

@Component
@Order(2)
public class LoadUserData implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		for(int i = 1; i < 10; i++){
			User user =  new User(i, "rocky"+i, "998877"+i, 1+i);
			userRepository.save(user);
		}
		
		userRepository.findAll().forEach(System.out::println);
		
	}

}
