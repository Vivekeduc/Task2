package com.caveofprogramming.web.offers;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO {
	@Autowired
	  DataSource datasource;

	@Autowired
	  JdbcTemplate jdbcTemplate;
	
	//public void setDataSource(DataSource dataSource) {
		//this.dataSource = dataSource;
	//}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.caveofprogramming.web.offers.IUserDAO#isValidUser(com.
	 * caveofprogramming.web.offers.User)
	 */

	@Override
	public boolean isValidUser(User user) {
try{
		String SQL = ("SELECT * from login where userId='" + user.getUserId() + "' and password='" + user.getPassword()+ "'");
	      User user1 =  (User) jdbcTemplate.queryForObject(SQL, new UserMapper());
	      return true;
}catch(EmptyResultDataAccessException e)
{
	return false; 
	}

	}

	

	

}
