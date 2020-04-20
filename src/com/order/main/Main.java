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
			e.printStackTrace();
		}
		/*
		 * Order order= new Order(); order=new DataFetch().fetchOrderDetails(502);
		 * System.out.println(order);
		 * 
		 * Wishlist wishlist= new Wishlist(); wishlist= new
		 * DataFetch().fetchWishlist(901); System.out.println(wishlist);
		 * 
		 * Cart cart= new Cart(); cart= new DataFetch().fetchCartDetails(907);
		 * System.out.println(cart);
		 * 
		 * //new DataFetch().addProductInCart(4, 905); //new
		 * DataFetch().addProductInWishList(7, 902); //new
		 * DataFetch().deleteProductFromCart(4, 905); new
		 * DataFetch().deleteProductFromWishList(7, 902);
		 */
	}

}
