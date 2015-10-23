package com.m4.ra.dao;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class BaseDaoImpl implements BaseDao {

	protected SessionFactory sessionFactory;
	protected BasicDataSource dataSource;
	protected JdbcTemplate coreJdbcTemplate;

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.intacct.iacpa.dao.BaseDao#flush()
	 */
	@Override
	public void flush(Boolean clearContext) {
		this.sessionFactory.getCurrentSession().flush();
		if (clearContext) {
			this.sessionFactory.getCurrentSession().clear();
		}
	}

	@Override
	public void setDataSource(BasicDataSource dataSource) {
		this.dataSource = dataSource;
		coreJdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public BasicDataSource getDataSource() {
		return this.dataSource;
	}
}
