package com.order.resource;

import com.order.bean.Product;
import com.order.bean.User;
import com.order.exception.ProductNotFoundException;
import com.order.exception.UserNotFoundException;
import com.order.util.DataFetch;

public class Main {
	public static void main(String args[]) {
		User user= new User();
		try {
			user=new DataFetch().getUser(902);
			System.out.println(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		//User user1= new User(908, "rashmi_prasad@persistent.com", "rashmi@123", 989788987, "kolkata","Rashmi Prasad");
		//new DataFetch().addUser(user1);
		Product product= new Product();
		try {
			product= new DataFetch().getProduct(1);
			System.out.println(product);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
