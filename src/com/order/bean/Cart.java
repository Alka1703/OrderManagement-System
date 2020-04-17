package com.order.bean;

import java.util.Set;

public class Cart {
	private Set<Product> item;
	private User user;
	public Cart(Set<Product> item, User user) {
		super();
		this.item = item;
		this.user = user;
	}
	public Set<Product> getItem() {
		return item;
	}
	public void setItem(Set<Product> item) {
		this.item = item;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Cart [item=" + item + ", user=" + user + "]";
	}
	
	

}
