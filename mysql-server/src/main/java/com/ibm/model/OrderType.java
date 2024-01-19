package com.ibm.model;

public enum OrderType {
	ELECTRONICS("Order Type is: ELECTRONICS"),
	HOUSEHOLD("Order Type is: HOUSEHOLD"),
	APPARELS("Order Type is: APPARELS"),
	CROCKERY("Order Type is: CROCKERY");
	private String type;
	private OrderType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
