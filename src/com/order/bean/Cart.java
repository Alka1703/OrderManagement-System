package com.order.bean;

import java.util.Set;

public class Cart {
	private int cartId;
	private Set<Product> item;
	private User user;
	
	public Cart() {
		super();
	}
	public Cart(int cartId, Set<Product> item, User user) {
		super();
		this.cartId=cartId;
		this.item = item;
		this.user = user;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
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
		return "Cart [cartId=" + cartId + ", item=" + item + ", user=" + user + "]";
	}
	
	

}
