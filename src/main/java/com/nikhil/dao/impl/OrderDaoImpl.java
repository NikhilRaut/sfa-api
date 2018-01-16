package com.nikhil.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.nikhil.dao.OrderDao;
import com.nikhil.model.DistributorSalesRepresentative;
import com.nikhil.model.Orders;
import com.nikhil.model.Retailer;
import com.nikhil.util.CustomHibernateDaoSupport;

@Repository("orderDao")
public class OrderDaoImpl extends CustomHibernateDaoSupport implements OrderDao {

	@SuppressWarnings("unchecked")
	public List<Orders> retailerOrders(String retailerId) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("retailerId", retailerId));
		criteria.setMaxResults(20);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Orders> retailerLatestOrder(String retailerId, int limit) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		criteria.add(Restrictions.eq("retailerId", getRetailerId(retailerId)));
		criteria.setMaxResults(limit);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Orders> retailerOrdersForDate(String retailerCode, String fromDate, String toDate) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		String retId = getRetailerId(retailerCode);
		System.out.println("Retailer : retId -------------------------- : " + retId);
		criteria.add(Restrictions.eq("retailerId", StringUtils.isEmpty(retId) ? retailerCode : retId));
		criteria.add(Restrictions.gt("orderDate", fromDate));
		criteria.add(Restrictions.lt("orderDate", toDate));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Orders> dsrOrdersForDate(String dsrCode, String fromDate, String toDate) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Orders.class);
		String dsrId = getDsrId(dsrCode);
		System.out.println("Retailer : retId -------------------------- : " + dsrId);
		criteria.add(Restrictions.eq("dsrId", StringUtils.isEmpty(dsrId) ? dsrCode : dsrId));
		criteria.add(Restrictions.gt("orderDate", fromDate));
		criteria.add(Restrictions.lt("orderDate", toDate));
		return criteria.list();
	}

	private String getRetailerId(String retailerCode) {
		try {
			Session session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Retailer.class);
			criteria.add(Restrictions.eq("code", retailerCode));
			Retailer retailer = (Retailer) criteria.list().get(0);
			System.out.println("Retailer : -------------------------- : " + retailer);
			return String.valueOf(retailer.getId());
		} catch (Exception e) {
			return "";
		}

	}

	private String getDsrId(String dsrCode) {
		try {
			Session session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(DistributorSalesRepresentative.class);
			criteria.add(Restrictions.eq("code", dsrCode));
			DistributorSalesRepresentative salesRepresentative = (DistributorSalesRepresentative) criteria.list()
					.get(0);
			System.out.println("DistributorSalesRepresentative : -------------------------- : " + salesRepresentative);
			return String.valueOf(salesRepresentative.getId());
		} catch (Exception e) {
			return "";
		}

	}
}
