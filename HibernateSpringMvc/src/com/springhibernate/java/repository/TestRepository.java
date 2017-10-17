package com.springhibernate.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.yaml.snakeyaml.events.Event.ID;

import com.springhibernate.java.model.User;

@Repository
public interface TestRepository extends JpaRepository<User, Integer>{
	
	@Query("select u from User u where u.username= :username")
	public User	findByUserName(@Param("username") String username);
	
	@Query("SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM User u WHERE u.username= :username")
	boolean checkIfUserNameExists(@Param("username") String username);
}
