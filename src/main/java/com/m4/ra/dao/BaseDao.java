package com.m4.ra.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;

public interface BaseDao {
	public SessionFactory getSessionFactory();

	public void setSessionFactory(SessionFactory sessionFactory);

	/**
	 * Force hibernate session to flush and, optionally, clear the context.
	 *
	 * @param clearContext Boolean
	 */
	public void flush(Boolean clearContext);

	public BasicDataSource getDataSource();

	public void setDataSource(BasicDataSource dataSource);
}
