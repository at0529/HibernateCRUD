package com.abc.pojo;



import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="customer_data")
public class Customer {

	@Id
	@GeneratedValue
	private Integer cust_id;
	
	@Column(name="cust_name")
	private String name;
	
	@Column(name="date_of_birth")
	private Date dob;
	
	@Embedded
	private Address address;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="cust_id")
	private List<Orders> orders;
	
	
	
}
