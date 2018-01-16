package com.nikhil.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.nikhil.dao.RetailerDao;
import com.nikhil.model.DistributorSalesRepresentative;
import com.nikhil.model.Orders;
import com.nikhil.model.Retailer;
import com.nikhil.util.CustomHibernateDaoSupport;

@Repository("retailerDao")
public class RetailerDaoImpl extends CustomHibernateDaoSupport implements RetailerDao {

	public Retailer retailerFromId(String retailerCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Retailer> dsrRetailerList(String dsrCode) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Retailer.class);
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
