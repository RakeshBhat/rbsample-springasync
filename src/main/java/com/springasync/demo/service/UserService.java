package com.springasync.demo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springasync.demo.data.repository.UserRepository;
import com.springasync.demo.domain.User;
import com.springasync.demo.service.async.AsyncUserComponent;

@Service
public class UserService {
	
	private AsyncUserComponent asyncUserComponent;
	private UserRepository userRepository;
	

	@Autowired
	public UserService(AsyncUserComponent asyncUserComponent) {
		this.asyncUserComponent = asyncUserComponent;
	}

	public void processIt(User user){
		userRepository.save(user);
		asyncUserComponent.processFee(user.getFee());
	}

	public User futureProcessIt(String it) throws InterruptedException, ExecutionException{
		return asyncUserComponent.futureProcessIt(it).get();
	}
	
    public void asyncMethodWithConfiguredExecutor() {
		 asyncUserComponent.asyncMethodWithConfiguredExecutor();
    }

    public void asyncMethodWithExceptions() throws Exception {
    	asyncUserComponent.asyncMethodWithExceptions();
	}
}
