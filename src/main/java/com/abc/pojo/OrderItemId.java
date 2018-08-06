package com.abc.pojo;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderItemId implements Serializable {

	private Integer order_id;

	private Integer item_id;
}
