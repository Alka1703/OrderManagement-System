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

public class DataFetch {
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
	
	public void deleteProduct(int productId) throws ProductNotFoundException{
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Delete from product where productId = '%d' ", productId);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with code %s not found", productId)));
		
	}
	public void updateProductPrice(int productId, int price) throws ProductNotFoundException{
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Update product set price = '%d' where productId = '%d'", price, productId);
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//============================================================================================================================================================================
//*************************************************** PRODUCT ******************************************************************************************************************
//=============================================================================================================================================================================	

}	
	
