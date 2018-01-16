package com.nikhil.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.nikhil.dao.StockDao;
import com.nikhil.model.DistributorSalesRepresentative;
import com.nikhil.model.Stock;
import com.nikhil.util.CustomHibernateDaoSupport;

@Repository("stockDao")
public class StockDaoImpl extends CustomHibernateDaoSupport implements StockDao {

	@SuppressWarnings("unchecked")
	public List<Stock> distributorStock(String dsrCode) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Stock.class);
		String distributorId = getDistributorId(dsrCode);
		criteria.add(Restrictions.eq("distributorId", StringUtils.isEmpty(distributorId) ? dsrCode : distributorId));
		return criteria.list();
	}

	private String getDistributorId(String dsrCode) {
		try {
			Session session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(DistributorSalesRepresentative.class);
			criteria.add(Restrictions.eq("code", dsrCode));
			DistributorSalesRepresentative salesRepresentative = (DistributorSalesRepresentative) criteria.list()
					.get(0);
			return salesRepresentative.getDistributorId();
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
	
	

}
