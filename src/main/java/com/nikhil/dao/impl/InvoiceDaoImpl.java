package com.nikhil.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nikhil.bo.RetailerBo;
import com.nikhil.dao.InvoiceDao;
import com.nikhil.model.Invoice;
import com.nikhil.model.Retailer;
import com.nikhil.util.CustomHibernateDaoSupport;

@Repository("invoiceDao")
public class InvoiceDaoImpl extends CustomHibernateDaoSupport implements InvoiceDao {
	@Autowired
	RetailerBo retailerBo;

	@SuppressWarnings("unchecked")
	public List<Invoice> retailerInvoices(String retailerCode) {
		Session session = getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(Invoice.class);
		criteria.createAlias("retailer", "ret");
		criteria.createAlias("invoice_amount", "a");
		criteria.createAlias("paid_amount", "b");
		criteria.add(Restrictions.eq("ret.code", retailerCode));
//		criteria.add(Restrictions.in(propertyName, values)("a", retailerCode));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Invoice> dsrRetailerInvoices(String dsrCode) {
		List<Invoice> invoices = new ArrayList<Invoice>();
		List<Retailer> retailers = retailerBo.dsrRetailerList(dsrCode);
		Session session = getSessionFactory().openSession();
		List<String> retaileCodes = new ArrayList<String>();
		for (int i = 0; i < retailers.size(); i++) {
			retaileCodes.add(retailers.get(i).getCode());
		}
		Criteria criteria = session.createCriteria(Invoice.class);
		criteria.createAlias("retailer", "ret");
		criteria.add(Restrictions.in("ret.code", retaileCodes));
		criteria.addOrder(Order.desc("date"));
		invoices.addAll(criteria.list());
		session.close();
		return invoices;
	}

}
