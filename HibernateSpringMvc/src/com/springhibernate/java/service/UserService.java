package com.springhibernate.java.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernate.java.dao.UserDAO;
import com.springhibernate.java.dao.UserDAoFromJpa;
import com.springhibernate.java.model.User;
import com.springhibernate.java.repository.TestRepository;
//import com.springhibernate.java.repository.TestRepository;

@Service
public class UserService 	{
	
	/*	@Autowired
	private TestRepository testRepository;
	
	public Collection<User> findAll(){
		Collection<User> users = (Collection<User>) testRepository.findAll();
		return users;
		
	}
	
	public TestRepository findOne() {
		User user = testRepository.findOne(userId);
		return null;
	}
	
	boolean exists(userId primaryKey) {
		return false;
	}
	*/
	
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	private TestRepository repository;
	
	public void printAll(){
		List<User> users = (List<User>) repository.findAll();
	    for(User usr: users){
	    	System.out.println(usr.getEmail());
	    }
	}
	 
	public List<User> findAllusers(){
		List<User> users = (List<User>) repository.findAll();
		return users;
	}

	public boolean checkIfUserNameExists(String username){
		return repository.checkIfUserNameExists(username);
	}
	
	public void addUser(User u) {
		repository.save(u);
	}

	@Transactional
	public void updateUser(User p) {
		this.userDAO.updateUser(p);
	}

	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	public User getUserById(String id)  throws Exception {
		return repository.findByUserName(id);
	}

	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

	
}
