package com.nikhil.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nikhil.dao.ProductDao;
import com.nikhil.model.Product;
import com.nikhil.util.CustomHibernateDaoSupport;

@Repository("productDao")
public class ProductDaoImpl extends CustomHibernateDaoSupport implements ProductDao {

	@SuppressWarnings("unchecked")
	public List<Product> product(String lastSync, int offSet, int limit) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.setFirstResult(offSet);
		criteria.setMaxResults(limit);
		criteria.add(Restrictions.gt("modifiedDate", lastSync));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> product(int offSet, int limit) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.setFirstResult(offSet);
		criteria.setMaxResults(limit);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> product() {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Product.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Product> product(String lastSync) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.gt("modifiedDate", lastSync));
		return criteria.list();
	}

}
