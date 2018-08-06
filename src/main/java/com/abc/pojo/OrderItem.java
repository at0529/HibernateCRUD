package com.abc.pojo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orderItem")
public class OrderItem {

	@EmbeddedId
	private OrderItemId orderItemID;
	
	private Integer quantity;
	
}
