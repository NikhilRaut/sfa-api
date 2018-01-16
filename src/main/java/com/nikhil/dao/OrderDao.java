package com.nikhil.dao;

import java.util.List;

import com.nikhil.model.Orders;

public interface OrderDao {
	List<Orders> retailerOrders(String retailerId);

	List<Orders> retailerLatestOrder(String retailerId, int limit);

	List<Orders> retailerOrdersForDate(String retailerId, String fromDate, String toDate);

	List<Orders> dsrOrdersForDate(String dsrId, String fromDate, String toDate);
}
