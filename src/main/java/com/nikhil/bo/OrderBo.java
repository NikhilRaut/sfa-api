package com.nikhil.bo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nikhil.model.Orders;

@Repository
public interface OrderBo {

	List<Orders> retailerOrders(String retailerId);
	
	List<Orders> retailerLatestOrder(String retailerId, int limit );
	
	List<Orders> retailerOrdersForDate(String retailerId, String fromDate, String toDate);
	
	List<Orders> dsrOrdersForDate(String dsrId, String fromDate, String toDate);
	
}
