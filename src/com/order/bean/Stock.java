package com.order.bean;

public class Stock {
	public int stockId;
	public Product product;
	public int quantity;
	
	public Stock(int stockId, Product product, int quantity) {
		super();
		this.stockId = stockId;
		this.product = product;
		this.quantity = quantity;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", product=" + product + ", quantity=" + quantity + "]";
	}

	
}
