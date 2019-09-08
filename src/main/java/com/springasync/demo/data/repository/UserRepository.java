package com.springasync.demo.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springasync.demo.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByPhone(@Param("phone") String phone);

}
