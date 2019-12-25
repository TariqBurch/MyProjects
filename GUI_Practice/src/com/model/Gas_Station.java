package com.model;

import java.io.Serializable;

public class Gas_Station implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double amount;
	private String type;
	private double price;
	
	public Gas_Station(String name, double amount, String type, double price) {

		this.name = name;
		this.amount = amount;
		this.type = type;
		this.price = price;
	}
	public Gas_Station() {
		this("",0.0,"",0.0);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	public void display() {
		System.out.println("Gas_Station [name=" + name + ", amount=" + amount + ", type=" + type + ", price=" + price + "]");
	}
	
	
	

	
}
