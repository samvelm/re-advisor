package com.m4.ra.dao;

import java.util.List;

import com.m4.ra.model.User;

public interface UserDao extends BaseDao {
	public void save(User user);

	public List<User> findAll();

	public User findById(String id);

	public User findByEmail(String email);

	public void delete(User user);
	
	public void update(User user);

}
