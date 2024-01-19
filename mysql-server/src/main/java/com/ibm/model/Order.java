package com.ibm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Order {
	private int orderID;
	private String orderName;
	private String orderDate;
	private OrderType orderTypes;
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", orderName=" + orderName + ", orderDate=" + orderDate + ", orderTypes="
				+ orderTypes.getType()+ "]";
	}
}
