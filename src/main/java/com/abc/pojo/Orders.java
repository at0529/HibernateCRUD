package com.abc.pojo;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue
	private Integer order_id;
	
	private Double price;
	
	@NonNull
	private Integer cust_id;
	
	private Date order_date;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="order_id")
	private List<OrderItem> orderItems;
	
	
	
}
