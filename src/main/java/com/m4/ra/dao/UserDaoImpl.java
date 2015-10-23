package com.m4.ra.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.m4.ra.model.User;

public class UserDaoImpl extends BaseDaoImpl implements UserDao {

	@Override
	@Transactional(readOnly = false)
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = session.createCriteria(
				User.class).list();
		return users;
	}

	@Override
	@Transactional(readOnly = false)
	public User findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		return (User) session.get(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Returns a user or null if not found
	 */
	public User findByEmail(String email) {
		User user = null;
		Session session = sessionFactory.getCurrentSession();
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("email", email);
		List<User> users = session.createCriteria(User.class)
				.add(Restrictions.allEq(properties)).list();
		if (users != null && !users.isEmpty()) {
			user = users.get(0);
		}
		return user;
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(user);

	}

	@Override
	@Transactional(readOnly = false)
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

	
}
