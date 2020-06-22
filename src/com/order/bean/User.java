package com.order.bean;

public class User {
	
	private int id;
	private String email,password,address,name,phone;
	public User() {
		
	}
	public User(int id, String email, String password, String address,String name,String phone) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.address = address;
		this.name=name;
		this.phone=phone;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", address=" + address + ", name="
				+ name + ", phone=" + phone + "]";
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
