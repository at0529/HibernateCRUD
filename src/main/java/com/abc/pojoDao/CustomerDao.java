package com.abc.pojoDao;

import com.abc.pojo.Customer;

public interface CustomerDao {

	Customer getCustomer(int id);
	
	Customer updateCustomer(Customer cus);
	
	Customer createCustomer(Customer cus);
	
	boolean deleteCustomer(int id);
	
	
}
