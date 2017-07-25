package com.caveofprogramming.web.offers;

public interface IUserDAO {

	public boolean isValidUser(User user);

	public boolean addUser(User user);
}

