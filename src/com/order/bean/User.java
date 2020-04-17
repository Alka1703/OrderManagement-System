package com.order.bean;

public class User {
	
	private int id;
	private String email,password,address,name;
	private int phone;
	
	public User() {
		
	}
	public User(int id, String email, String password, int phone, String address,String name) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone=phone;
		this.name=name;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", address=" + address + ", name="
				+ name + ", phone=" + phone + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
