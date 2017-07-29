package com.springhibernate.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernate.java.dao.UserDAO;
import com.springhibernate.java.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;

	@Transactional
	public void addUser(User u) {
		this.userDAO.addUser(u);
	}

	@Transactional
	public void updateUser(User p) {
		this.userDAO.updateUser(p);
	}

	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Transactional
	public User getUserById(int id)  throws Exception {
		return this.userDAO.getUserById(id);
	}

	@Transactional
	public void removeUser(int id) {
		this.userDAO.removeUser(id);
	}

	
}
