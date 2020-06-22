package com.order.resource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.order.Exception.ExceptionMessage;
import com.order.Exception.ProductNotFoundException;
import com.order.Exception.UserAlreadyExist;
import com.order.Exception.UserNotFoundException;
import com.order.bean.Category;
import com.order.bean.Product;
import com.order.util.DatabaseConnection;

public class Main {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			connection=dc.createConnection();
	}

	public static void main(String args[]) throws UserNotFoundException, UserAlreadyExist {
		
		try {
			System.out.println("alka");
			ArrayList<Product>pr= new ArrayList<Product>();
			Statement statement= connection.createStatement();
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
				System.out.println(product);
				pr.add(product);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	

}
