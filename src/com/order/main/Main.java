package com.order.main;

import java.util.ArrayList;
import com.order.bean.Product;
import com.order.bean.User;
import com.order.exception.ProductNotFoundException;
import com.order.exception.UserNotFoundException;
import com.order.util.DataFetch;

public class Main {
	public static void main(String args[]) {
		try {
			User user = new User();
			user=new DataFetch().getUser(902);
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*try {
			new DataFetch().deleteUser(901);
			//System.out.println(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		/*
		 * try { new DataFetch().updateUserEmail(902, "alka1_prasad@persistent.com"); }
		 * catch (UserNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		Product product = new Product();
		try {
			product=new DataFetch().getProduct(9);
			System.out.println(product);
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ArrayList<Product> pr= new DataFetch().getAllProducts();
			for(Product p: pr)
				System.out.println(p);
		} catch (ProductNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
