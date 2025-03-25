package com.practice.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.training.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	 User findByUsername(String username);
}
