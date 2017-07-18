package com.caveofprogramming.web.offers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		// ResultSet rs;
		user.setUserId(rs.getString("userID"));
		user.setPassword(rs.getString("password"));

		return user;
	}

}
