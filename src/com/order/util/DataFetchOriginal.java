package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import com.order.bean.Cart;
import com.order.bean.Category;
import com.order.bean.Order;
import com.order.bean.OrderStatus;
import com.order.bean.Product;
import com.order.bean.User;
import com.order.bean.Wishlist;
import com.order.exception.ExceptionMessage;
import com.order.exception.ProductNotFoundException;
import com.order.exception.UserNotFoundException;

public class DataFetchOriginal {
	static Connection connection;
	Statement statement;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			try {
				connection=dc.createConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
//============================================================================================================================================================================
//*************************************************** USER	*******************************************************************************************************************
//=============================================================================================================================================================================	

//Function to fetch user details from the user table in the database and store it in a user object
	
	public User getUser(int userId) throws UserNotFoundException {
		try {
			statement= connection.createStatement();
			ResultSet resultSet;
			String sql;
			sql=String.format("SELECT * FROM user WHERE UserId = '%d'", userId);
			User user= new User();
			resultSet= statement.executeQuery(sql);
			if(resultSet.next()){
				
				user.setId(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("Email"));
				user.setAddress(resultSet.getString("Address"));
				user.setPhone(resultSet.getInt("Phone"));
				user.setPassword(resultSet.getString("Password"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UserNotFoundException(new ExceptionMessage(String.format("%d not found", userId)));
	}
	
//Function to register a new user to the database
	
	public void addUser(User user){
		try {
			statement= connection.createStatement();
			String sql;
			sql=String.format("Insert into user values('%d','%s', '%s','%s', '%s','%d')",
								user.getId(), user.getEmail(),user.getPassword(),user.getAddress(),user.getName(),user.getPhone());
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
//Funciton to check user login :
	public boolean CheckLogin(String email, String pass) {
		boolean flag= false;
		String Select_sql="select * from user where email='"+email+"' and password='"+pass+"'";
		try
		{
			DatabaseConnection dbcon=new DatabaseConnection();
			Connection con=dbcon.createConnection();
			Statement statament=con.prepareStatement(Select_sql);
			ResultSet resultSet=statament.executeQuery(Select_sql);
			if (resultSet.next())
			{
				System.out.println("Correct");
				flag = true;
			}
			else
			{
				System.out.println("incorrect");
				flag = false;
			}
		}
		catch(SQLException sqe)
		{
			sqe.printStackTrace();
		}
		return flag;
	}	
//============================================================================================================================================================================
//*************************************************** USER	*******************************************************************************************************************
//=============================================================================================================================================================================	

	
	
//============================================================================================================================================================================
//*************************************************** PRODUCT *******************************************************************************************************************
//=============================================================================================================================================================================	

	
//function to fetch product from the product table in the database and store it in product object
	
	public Product getProduct(int productId) throws ProductNotFoundException {
		try {
			statement= connection.createStatement();
			ResultSet resultSet;
			String sql;
			sql=String.format("SELECT * FROM product WHERE ProductId = '%d'", productId);
			Product product= new Product();
			resultSet= statement.executeQuery(sql);
			if(resultSet.next()) {
				product.setProductId(resultSet.getInt("ProductId"));
				product.setCode(resultSet.getString("ProductCode"));
				product.setDescription(resultSet.getString("Description"));
				product.setName(resultSet.getString("Name"));
				product.setPrice(resultSet.getInt("Price"));
				product.setCategory(Category.valueOf(resultSet.getString("Category")));
			}
			return product;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with code %s not found", productId)));
	}

//Function to add the given product in the product table in the database

	public void addProduct(Product product){
		try {
			statement= connection.createStatement();
			String sql;
			sql=String.format("Insert into product values('%d','%s', '%s','%s', '%d','%s')",
								product.getProductId(),product.getCode(),product.getName(), product.getDescription(), product.getPrice(), product.getCategory());
			statement.execute(sql);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//============================================================================================================================================================================
//*************************************************** PRODUCT ******************************************************************************************************************
//=============================================================================================================================================================================	

	
	
//============================================================================================================================================================================
//*************************************************** ORDER ******************************************************************************************************************
//=============================================================================================================================================================================	
	
	public void placeOrder(Order order) {
		try {
			statement= connection.createStatement();
			String sql;
			sql=String.format("Insert into 'order' values('%d','%s','%s','%d','%s')", 
								order.getOrderId(), order.getNumber(),order.getOrderedOn(),order.getOrderedBy().getId(),order.getStatus());
			statement.execute(sql);
			for(Product p: order.getCart()) {
				sql=String.format("Insert into items values('%d','%d')",order.getOrderId(), p.getProductId());
				statement.execute(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Order fetchOrderDetails(int orderId) {
		Order order= new Order();
		try {
			statement=connection.createStatement();
			String sql;
			sql=String.format("Select * from orders WHERE orderId= '%d'",orderId);
			ResultSet resultSet;
			resultSet=statement.executeQuery(sql);
			int userId=0;
			if(resultSet.next()) {
				order.setOrderId(resultSet.getInt("orderId"));
				order.setNumber(resultSet.getString("orderNum"));
				order.setOrderedOn(resultSet.getDate("orderedOn"));
				order.setStatus(OrderStatus.valueOf(resultSet.getString("status")));
				userId= resultSet.getInt("OrderedBy");
			}
			sql= String.format("Select * from user WHERE userId= '%d' ",(userId));
			resultSet= statement.executeQuery(sql);
			User user= new User();
			if(resultSet.next()){
				user.setId(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("Email"));
				user.setAddress(resultSet.getString("Address"));
				user.setPhone(resultSet.getInt("Phone"));
				user.setPassword(resultSet.getString("Password"));
			}
			order.setOrderedBy(user);
			sql = String.format("Select ProductId from items WHERE orderId = '%d'",(order.getOrderId()));
			resultSet=statement.executeQuery(sql);
			Set<Product>pr= new HashSet<Product>();
			Vector<Integer>temp=  new Vector<Integer>();
			while(resultSet.next()) {
				temp.add(resultSet.getInt("ProductId"));
			}
			for(int t:temp) {
				Product product= new Product();
				sql=String.format("SELECT * FROM product WHERE ProductId = '%d'", t);
				resultSet= statement.executeQuery(sql);
				if(resultSet.next()) {
					product.setProductId(resultSet.getInt("ProductId"));
					product.setCode(resultSet.getString("ProductCode"));
					product.setDescription(resultSet.getString("Description"));
					product.setName(resultSet.getString("Name"));
					product.setPrice(resultSet.getInt("Price"));
					product.setCategory(Category.valueOf(resultSet.getString("Category")));
				}
				pr.add(product);
			}
			order.setCart(pr);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
	
	
//============================================================================================================================================================================
//**************************************************************** ORDER ******************************************************************************************************************
//=============================================================================================================================================================================	
	

	
//============================================================================================================================================================================
//**************************************************************** WISHLIST ******************************************************************************************************************
//=============================================================================================================================================================================	

	///incomplete function
	public void addWishlist(Wishlist wishlist) {
		try {
			statement= connection.createStatement();
			String sql;
			sql=String.format("Insert into wishlist values ('%d', '%d')",wishlist.getWishlistId(), wishlist.getWishedBy().getId());
			statement.execute(sql);
			for(Product p: wishlist.getWishes()) {
				sql=String.format("Insert into wishes values('%d','%d')",wishlist.getWishlistId(), p.getProductId());
				statement.execute(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Wishlist fetchWishlist(int userId) {
		Wishlist wishlist= new Wishlist();
		try {
			statement= connection.createStatement();
			String sql;
			sql=String.format("Select * from wishlist WHERE WishedBy= '%d'",userId);
			ResultSet resultSet= statement.executeQuery(sql);
			if(resultSet.next()) 
				wishlist.setWishlistId(resultSet.getInt("WishlistId"));
			sql= String.format("Select * from user WHERE userId= '%d' ",(userId));
			resultSet= statement.executeQuery(sql);
			User user= new User();
			if(resultSet.next()){
				user.setId(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("Email"));
				user.setAddress(resultSet.getString("Address"));
				user.setPhone(resultSet.getInt("Phone"));
				user.setPassword(resultSet.getString("Password"));
			}
			wishlist.setWishedBy(user);
			sql = String.format("Select ProductId from wishes WHERE WishlistId = '%d'",(wishlist.getWishlistId()));
			resultSet=statement.executeQuery(sql);
			Set<Product>pr= new HashSet<Product>();
			Vector<Integer>temp=  new Vector<Integer>();
			while(resultSet.next()) {
				temp.add(resultSet.getInt("ProductId"));
			}
			for(int t:temp) {
				Product product= new Product();
				sql=String.format("SELECT * FROM product WHERE ProductId = '%d'", t);
				resultSet= statement.executeQuery(sql);
				if(resultSet.next()) {
					product.setProductId(resultSet.getInt("ProductId"));
					product.setCode(resultSet.getString("ProductCode"));
					product.setDescription(resultSet.getString("Description"));
					product.setName(resultSet.getString("Name"));
					product.setPrice(resultSet.getInt("Price"));
					product.setCategory(Category.valueOf(resultSet.getString("Category")));
				}
				pr.add(product);
			}
			wishlist.setWishes(pr);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return wishlist;
	}
	
	public void addProductInWishList(int productId, int userId) {	
		try {
			statement=connection.createStatement();
			String sql;int wishlistId=0;
			sql= String.format("Select wishlistId from wishlist where WishedBy= '%d'", userId);
			ResultSet resultSet= statement.executeQuery(sql);
			if(resultSet.next())
				wishlistId=resultSet.getInt("wishlistId");
			sql=String.format("Insert into wishes values ('%d', '%d')", wishlistId, productId);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProductFromWishList(int productId, int userId) {	
		try {
			statement=connection.createStatement();
			String sql;
			int wishlistId=0;
			sql= String.format("Select wishlistId from wishlist where WishedBy= '%d'", userId);
			ResultSet resultSet= statement.executeQuery(sql);
			if(resultSet.next())
				wishlistId=resultSet.getInt("wishlistId");
			sql=String.format("delete from wishes where wishlistId = '%d' and productId = '%d'", wishlistId, productId);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//============================================================================================================================================================================
//**************************************************************** WISHLIST ******************************************************************************************************************
//=============================================================================================================================================================================	

	
//============================================================================================================================================================================
//**************************************************************** CART ******************************************************************************************************************
//=============================================================================================================================================================================	

	public Cart fetchCartDetails(int userId) {
		Cart cart = new Cart();
		try {
			statement= connection.createStatement();
			String sql;
			sql=String.format("Select * from cart WHERE UserId= '%d'",userId);
			ResultSet resultSet= statement.executeQuery(sql);
			if(resultSet.next()) 
				cart.setCartId(resultSet.getInt("CartId"));
			sql= String.format("Select * from user WHERE userId= '%d' ",(userId));
			resultSet= statement.executeQuery(sql);
			User user= new User();
			if(resultSet.next()){
				user.setId(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("Email"));
				user.setAddress(resultSet.getString("Address"));
				user.setPhone(resultSet.getInt("Phone"));
				user.setPassword(resultSet.getString("Password"));
			}
			cart.setUser(user);
			sql = String.format("Select ProductId from cart_items WHERE cartId = '%d'",(cart.getCartId()));
			resultSet=statement.executeQuery(sql);
			Set<Product>pr= new HashSet<Product>();
			Vector<Integer>temp=  new Vector<Integer>();
			while(resultSet.next()) {
				temp.add(resultSet.getInt("ProductId"));
			}
			for(int t:temp) {
				Product product= new Product();
				sql=String.format("SELECT * FROM product WHERE ProductId = '%d'", t);
				resultSet= statement.executeQuery(sql);
				if(resultSet.next()) {
					product.setProductId(resultSet.getInt("ProductId"));
					product.setCode(resultSet.getString("ProductCode"));
					product.setDescription(resultSet.getString("Description"));
					product.setName(resultSet.getString("Name"));
					product.setPrice(resultSet.getInt("Price"));
					product.setCategory(Category.valueOf(resultSet.getString("Category")));
				}
				pr.add(product);
			}
			cart.setItem(pr);	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;	
	}
	
	public void createCart(Cart cart) {
		try {
			statement= connection.createStatement();
			String sql;
			sql=String.format("Insert into cart values ('%d', '%d')",cart.getCartId(), cart.getUser().getId());
			statement.execute(sql);
			for(Product p: cart.getItem()) {
				sql=String.format("Insert into cart_items values('%d','%d')",cart.getCartId(), p.getProductId());
				statement.execute(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addProductInCart(int productId, int userId) {	
		try {
			statement=connection.createStatement();
			String sql;int cartId=0;
			sql= String.format("Select cartId from cart where UserId = '%d'", userId);
			ResultSet resultSet= statement.executeQuery(sql);
			if(resultSet.next())
				cartId=resultSet.getInt("cartId");
			sql=String.format("Insert into cart_items values ('%d', '%d')", cartId, productId);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteProductFromCart(int productId, int userId) {
		try {
			statement=connection.createStatement();
			String sql;
			int cartId=0;
			sql= String.format("Select cartId from cart where UserId = '%d'", userId);
			ResultSet resultSet= statement.executeQuery(sql);
			if(resultSet.next())
				cartId=resultSet.getInt("cartId");
			sql=String.format("Delete from cart_items where productId= '%d' and cartId = '%d'", productId,cartId);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//============================================================================================================================================================================
//**************************************************************** CART ******************************************************************************************************************
//=============================================================================================================================================================================	

}






