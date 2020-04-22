package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.order.bean.Category;
import com.order.bean.Product;
import com.order.bean.User;
import com.order.exception.CategoryNotFoundException;
import com.order.exception.ExceptionMessage;
import com.order.exception.ProductNotFoundException;
import com.order.exception.UserNotFoundException;

public class DataFetch {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			try {
				connection=dc.createConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	

	/*
	 * public boolean CheckLogin(String email, String pass) { boolean flag= false;
	 * String
	 * Select_sql="select * from user where email='"+email+"' and password='"+pass+
	 * "'"; try { DatabaseConnection dbcon=new DatabaseConnection(); Connection
	 * con=dbcon.createConnection(); Statement
	 * statament=con.prepareStatement(Select_sql); ResultSet
	 * resultSet=statament.executeQuery(Select_sql); if (resultSet.next()) {
	 * System.out.println("Correct"); flag = true; } else {
	 * System.out.println("incorrect"); flag = false; } } catch(SQLException sqe) {
	 * sqe.printStackTrace(); } return flag; }
	 */	
//============================================================================================================================================================================
//*************************************************** USER	*******************************************************************************************************************
//=============================================================================================================================================================================	

//Function to fetch user details from the user table in the database and store it in a user object
	
	public User getUser(int userId) throws UserNotFoundException {
		System.out.println("Data");
		try {
			statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
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
				System.out.println(user);
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String temp=String.format("User with ID %d not found", userId);
		throw new UserNotFoundException(new ExceptionMessage(temp));
	}
	
	public ArrayList<User> getAllUsers() {
		
		try {
			statement= connection.createStatement();
			ArrayList<User>u= new ArrayList<User>();
			ResultSet resultSet;
			String sql;
			sql=String.format("SELECT * FROM user");
			resultSet= statement.executeQuery(sql);
			while(resultSet.next()){
				User user= new User();
				user.setId(resultSet.getInt("userid"));
				user.setName(resultSet.getString("name"));
				user.setEmail(resultSet.getString("Email"));
				user.setAddress(resultSet.getString("Address"));
				user.setPhone(resultSet.getInt("Phone"));
				user.setPassword(resultSet.getString("Password"));
				u.add(user);
			}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
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
	
	public void deleteUser(int userId) throws UserNotFoundException{
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Delete from user where userid = %d ", userId);
			System.out.println(sql);
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UserNotFoundException(new ExceptionMessage(String.format("User with ID %d not found", userId)));
	}
	public void updateUserEmail(int userId, String email) throws UserNotFoundException {
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Update user set email = '%s' where userId = '%d'", email, userId);
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Not found");
		throw new UserNotFoundException(new ExceptionMessage(String.format("User with ID %d not found", userId)));

	}
	
	public void updateUserPhone(int userId, int phone) throws UserNotFoundException {
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Update  user set phone = '%d' where userId = '%d'", phone, userId);
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UserNotFoundException(new ExceptionMessage(String.format("User with ID %d not found", userId)));
	}
	
	public void updateUserAddress(int userId, String address) throws UserNotFoundException {
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Update  user set address = '%s' where userId = '%d'", address, userId);
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UserNotFoundException(new ExceptionMessage(String.format("User with ID %d not found", userId)));
	}
	
	public void updateUserPassword(int userId, String password) throws UserNotFoundException {
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Update  user set password = '%s' where userId = '%d'", password, userId);
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UserNotFoundException(new ExceptionMessage(String.format("User with ID %d not found", userId)));
	}
	
	public void updateUserName(int userId, String name) throws UserNotFoundException {
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Update  user set name = '%s' where userId = '%d'", name, userId);
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UserNotFoundException(new ExceptionMessage(String.format("User with ID %d not found", userId)));
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
			int categoryId=0;
			sql=String.format("SELECT * FROM product WHERE ProductId = '%d'", productId);
			Product product= new Product();
			Category category= new Category();
			resultSet= statement.executeQuery(sql);
			if(resultSet.next()) {
				product.setProductId(resultSet.getInt("ProductId"));
				product.setCode(resultSet.getString("ProductCode"));
				product.setDescription(resultSet.getString("Description"));
				product.setName(resultSet.getString("Name"));
				product.setPrice(resultSet.getInt("Price"));
				categoryId=resultSet.getInt("Category");
			}
			sql=String.format("Select * from category where categoryId = '%d'", categoryId);
			resultSet= statement.executeQuery(sql);
			//Category category;
			if(resultSet.next()) {
				category.setCategoryName(resultSet.getString("CategoryName"));
				category.setCategoryId(categoryId);
			}
			product.setCategory(category);
			return product;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with ID %d not found", productId)));
	}
	
	public ArrayList<Product> getAllProducts() throws ProductNotFoundException {
		try {
			ArrayList<Product>pr= new ArrayList<Product>();
			statement= connection.createStatement();
			ResultSet resultSet;
			ResultSet resultSet1;
			String sql;
			int categoryId=0;
			sql=String.format("SELECT * FROM product");
			
			resultSet= statement.executeQuery(sql);
			while(resultSet.next()) {
				Product product= new Product();
				Category category= new Category();
				product.setProductId(resultSet.getInt("ProductId"));
				product.setCode(resultSet.getString("ProductCode"));
				product.setDescription(resultSet.getString("Description"));
				product.setName(resultSet.getString("Name"));
				product.setPrice(resultSet.getInt("Price"));
				categoryId=resultSet.getInt("Category");
				Statement statement1=connection.createStatement();
				sql=String.format("Select * from category where categoryId = '%d'", categoryId);
				resultSet1= statement1.executeQuery(sql);
				if(resultSet1.next()) {
					category.setCategoryName(resultSet1.getString("CategoryName"));
					category.setCategoryId(categoryId);
				}
				product.setCategory(category);
				pr.add(product);
			}
			return pr;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}


	//Function to add the given product in the product table in the database

	public void addProduct(Product product){
		try {
			statement= connection.createStatement();
			String sql; 
			ResultSet resultSet;
			String categoryName=product.getCategory().getCategoryName();
			sql=String.format("Select CategoryId from category where categoryName = '%s'", categoryName);
			resultSet= statement.executeQuery(sql);
			int categoryId=0;
			if(resultSet.next())
				categoryId =resultSet.getInt("CategoryId");
			
			
			sql=String.format("Insert into product values('%d','%s', '%s','%s', '%d','%d')",
								product.getProductId(),product.getCode(),product.getName(), product.getDescription(), product.getPrice(), categoryId);
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
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with ID %d not found", productId)));
		
	}
	public void updateProductPrice(int productId, int price) throws ProductNotFoundException{
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Update product set price = '%d' where productId = '%d'", price, productId);
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with ID %d not found", productId)));

	}
	
	
	
//============================================================================================================================================================================
//*************************************************** PRODUCT ******************************************************************************************************************
//=============================================================================================================================================================================	

	
	public Category getCategory(int categoryId) throws CategoryNotFoundException{
		Category category= new Category();
		try {
			statement= connection.createStatement();
			ResultSet resultSet;
			String sql;
			sql= String.format("Select * from Category where categoryId = '%d'", categoryId);
			resultSet= statement.executeQuery(sql);
			if(resultSet.next()) {
				category.setCategoryId(categoryId);
				category.setCategoryName(resultSet.getString("categoryName"));
			}
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new CategoryNotFoundException(new ExceptionMessage(String.format("Category with ID %d not found", categoryId)));
	}
	
	public void addCategory(Category category) {
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Insert into Category values ('%d', '%s')", category.getCategoryId(), category.getCategoryName());
			statement.execute(sql);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteCategory(int categoryId) throws CategoryNotFoundException{
		try {
			statement= connection.createStatement();
			String sql;
			sql= String.format("Delete from Category where CategoryId= '%d'", categoryId);
			statement.execute(sql);
			return ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new CategoryNotFoundException(new ExceptionMessage(String.format("Category with ID %d not found", categoryId)));
	}
	
	public ArrayList<Category> fetchAllCategory() {
		try {
			statement= connection.createStatement();
			ArrayList<Category>category= new ArrayList<Category>();
			String sql= String.format("Select * from category");
			ResultSet resultSet= statement.executeQuery(sql);
			while(resultSet.next()) {
				Category c= new Category();
				c.setCategoryId(resultSet.getInt("CategoryId"));
				c.setCategoryName(resultSet.getString("CategoryName"));
				category.add(c);
			}
			return category;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}	
	
