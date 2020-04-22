package com.order.main;

import com.order.bean.Cart;
import com.order.bean.Order;
import com.order.bean.Product;
import com.order.bean.User;
import com.order.bean.Wishlist;
import com.order.exception.ProductNotFoundException;
import com.order.exception.UserNotFoundException;
import com.order.util.DataFetch;

public class Main {
	public static void main(String args[]) {
		User user = new User();
		try {
			user=new DataFetch().getUser(902);
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			new DataFetch().deleteUser(901);
			//System.out.println(user);
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			new DataFetch().updateUserEmail(902, "alka1_prasad@persistent.com");
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
