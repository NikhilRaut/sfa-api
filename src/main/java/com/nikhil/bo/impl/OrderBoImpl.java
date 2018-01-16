package com.nikhil.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikhil.bo.OrderBo;
import com.nikhil.dao.OrderDao;
import com.nikhil.model.Orders;


@Repository("orderBo")
public class OrderBoImpl implements OrderBo {
	

	@Autowired
	OrderDao orderDao;

	public List<Orders> retailerOrders(String retailerId) {
		return orderDao.retailerOrders(retailerId);
	}

	public List<Orders> retailerLatestOrder(String retailerId, int limit) {
		return orderDao.retailerLatestOrder(retailerId, limit);
	}

	public List<Orders> retailerOrdersForDate(String retailerId, String fromDate, String toDate) {
		return orderDao.retailerOrdersForDate(retailerId, fromDate, toDate);
	}

	public List<Orders> dsrOrdersForDate(String dsrId, String fromDate, String toDate) {
		return orderDao.dsrOrdersForDate(dsrId, fromDate, toDate);
	}

}
