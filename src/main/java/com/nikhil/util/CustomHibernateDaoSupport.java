package com.nikhil.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.hibernate.SessionFactory;

public abstract class CustomHibernateDaoSupport extends HibernateDaoSupport {
	@Autowired
	public void anyMethodName(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
}
