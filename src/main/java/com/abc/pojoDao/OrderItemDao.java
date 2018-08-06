package com.abc.pojoDao;

import com.abc.pojo.OrderItem;
import com.abc.pojo.OrderItemId;

public interface OrderItemDao {

	OrderItem getOrderItem(OrderItemId id);
	
	OrderItem updateOrderItem(OrderItem cus);
	
	OrderItem createOrderItem(OrderItem cus);
	
	boolean deleteOrderItem(OrderItemId id);
	
}
