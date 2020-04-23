package com.order.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Product {
	
	private int productId;
	private String code,name,description;
	private int price;
	private Category category;
	public Product() {
		
	}
	public Product(int productId, String code, String name, String description, int price,Category category) {
		
		this.productId = productId;
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category=category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", code=" + code + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", category=" + category + "]";
	}
	
	
	
}
