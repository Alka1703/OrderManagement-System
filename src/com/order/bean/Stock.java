package com.order.bean;

public class Stock {
	private int productId;
	private int stock;
	private int categoryId;
	
	public Stock() {
		super();
	}
	public Stock(int productId, int stock, int categoryId) {
		super();
		this.productId = productId;
		this.stock = stock;
		this.categoryId= categoryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
}
