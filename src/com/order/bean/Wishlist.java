package com.order.bean;

import java.util.Set;

public class Wishlist {
	private int wishlistId;
	private User wishedBy;
	private Set<Product> wishes;
	
	public Wishlist(int wishlistId, User wishedBy, Set<Product> wishes) {
		super();
		this.wishlistId = wishlistId;
		this.wishedBy = wishedBy;
		this.wishes = wishes;
	}
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public User getWishedBy() {
		return wishedBy;
	}
	public void setWishedBy(User wishedBy) {
		this.wishedBy = wishedBy;
	}
	public Set<Product> getWishes() {
		return wishes;
	}
	public void setWishes(Set<Product> wishes) {
		this.wishes = wishes;
	}
}
