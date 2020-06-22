package com.order.bean;

public class Sell {
	private int categoryId;
	private int qty;
	
	public Sell() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sell(int categoryId, int qty) {
		super();
		this.categoryId = categoryId;
		this.qty = qty;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
