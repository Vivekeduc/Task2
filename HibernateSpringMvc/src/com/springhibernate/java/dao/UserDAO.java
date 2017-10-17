package com.springhibernate.java.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.springhibernate.java.model.User;


@Repository
public class UserDAO{
	
	@Autowired
	private SessionFactory sessionFactory;


	public void addUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(u);
		System.out.println("User saved successfully, User Details="+u);
	}
	
	public void updateUser(User u) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(u);
		System.out.println("User updated successfully, User Details="+u);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery("from User").list();
		for(User u : usersList){
			System.out.println("User List::"+u);
		}
		return usersList;
	}
	
	public User getUserById(String userId) throws Exception {
		try{
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr= session.createCriteria(User.class)
				.add(Restrictions.eq("username", userId));
		User u = (User) cr.uniqueResult();
		return u;
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
		
	}
	
	public void removeUser(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Integer(userId));
		if(null != u){
			session.delete(u);
		}
		System.out.println("User deleted successfully, user details="+u);
	}


/*	@Autowired
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
	/*
//	@Override
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

	//@Override
	public boolean addUser(User user) {
		
		System.out.println(user.getUserId());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getPhone());
		System.out.println(user.getCity());
		
		SessionFactory sessionfactory = Hibernate.getSessionFactory();
		
		Session session = sessionfactory.openSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		//
//		String InsertQuery = "insert into  users.login(userId,password,email,phone,city) values(?,?,?,?,?)";
//		Query query = session.createQuery(InsertQuery);
//		query.setString(0,user.getUserId());
//		query.setString(1,user.getPassword());
//		query.setString(2,user.getEmail());
//		query.setString(3,user.getCity());
//		query.setString(4,user.getPhone());
		
//		int i=jdbcTemplate.update(InsertQuery,user.getUserId(),user.getPassword(),user.getEmail(),user.getPhone(),user.getCity());
//		if(i==1){
//		return true;
//		}
//		return false;	
		if(session.save(user)==null){
			return false;
		}else
			{
			session.getTransaction().commit();
			return true;
			}
		
		//return true;
	}
	
//    public boolean addProduct(Product product) {
//		  
//String InsertQuery = "insert into  sample.product(id,name,description,cost) values(?,?,?,?)";
//
//int i=jdbcTemplate.update(InsertQuery,product.getId(),product.getName(),product.getDescription(),product.getPrice());
//if(i==1){
//return true;
//}
//return false;
//}

//	@Override
//	public boolean addUser(User user) {
//		try{
//			String SQL1 = ("INSERT into login '" + user.getUserId() + "' and password='" + user.getPassword()+ "'");
//		      User user1 =  (User) jdbcTemplate.queryForObject(SQL1, new UserMapper());
//		      return true;
//	}catch(EmptyResultDataAccessException e)
//	{
//		return false;
//	}*/

	}
	


