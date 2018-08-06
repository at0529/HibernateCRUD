package com.abc.pojoDao;

import com.abc.pojo.Orders;

public interface OrdersDao {


	Orders getOrders(int id);
	
	Orders updateOrders(Orders ord);
	
	Orders createOrders(Orders ord);
	
	boolean deleteOrders(int id);
	
}
