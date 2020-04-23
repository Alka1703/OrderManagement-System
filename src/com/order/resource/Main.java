package com.order.resource;

import com.order.Exception.UserNotFoundException;
import com.order.bean.User;
import com.order.util.DatabaseOperation;

public class Main {
	public static void main(String args[]) throws UserNotFoundException {
		DatabaseOperation db=new DatabaseOperation();
		
		User user=new User(3, "q","qwerty", "asasas","aa", "12345");
		//db.createUser(user);
		user.setEmail("dfgf");
		user.setName("Pulkit");
		System.out.println(user.toString());
		user.setPassword("kgf");
		db.updateUser(user);
	}

}
