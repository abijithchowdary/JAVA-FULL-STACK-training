package com.capg.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.springboot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User , Long> {
	
	Optional<User> findByUserId(Long userId);
	
	Optional<User> findByEmail(String email);
	
	boolean existsByEmail(String email);
	
	boolean existsByUserId(Long userId);
	
	List<User> findByRole(String role);
}
