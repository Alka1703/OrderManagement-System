package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.order.bean.Category;
import com.order.bean.Product;
import com.order.Exception.ExceptionMessage;
import com.order.Exception.ProductAlreadyExist;
import com.order.Exception.ProductNotFoundException;

public class ProductDataFetch {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			connection=dc.createConnection();
	}
	
//function to fetch product from the product table in the database and store it in product object
	public Product getProduct(int productId) throws ProductNotFoundException {
		try {
			Statement statement1=connection.createStatement();
			statement= connection.createStatement();
			ResultSet resultSet;
			String sql;
			int categoryId=0;
			sql=String.format("SELECT * FROM product WHERE ProductId = '%d' ", productId);
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
				String sql1=String.format("Select * from category where categoryId = '%d'", categoryId);
				ResultSet resultSet1= statement1.executeQuery(sql1);
				if(resultSet1.next()) {
					category.setCategoryName(resultSet1.getString("CategoryName"));
					category.setCategoryId(categoryId);
				}
				product.setCategory(category);
				return product;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with Id %d not found", productId)));
	}
	
	public ArrayList<Product> getAllProducts() throws ProductNotFoundException {
		try {
			System.out.println("alka");
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
				System.out.println(product);
				pr.add(product);
			}
			if(pr.size()==0)
				throw new ProductNotFoundException(new ExceptionMessage(String.format("No Product Found")));
			return pr;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
//Function to add the given product in the product table in the database
	public Product addProduct(Product product) throws ProductAlreadyExist{
		try {
			statement= connection.createStatement();
			String sql, s;
			s=String.format("SELECT * FROM product WHERE ProductId = '%d' ", product.getProductId());
			ResultSet rs= statement.executeQuery(s);
			if(rs.next()) {
				throw new ProductAlreadyExist(new ExceptionMessage(String.format("Product with ID %d already exists", product.getProductId())));
			}
			sql=String.format("Insert into product values('%d','%s', '%s','%s', '%d','%d')",
								product.getProductId(), product.getCode(),product.getName(), product.getDescription(), product.getPrice(), product.getCategory().getCategoryId());
			statement.execute(sql);	
			sql= String.format("Insert into stock values('%d','%d','%d')", product.getProductId(),product.getCategory().getCategoryId(),0);
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public Product deleteProduct(int productId) throws ProductNotFoundException{
		try {
			statement= connection.createStatement();
			Statement statement1= connection.createStatement();
			String sql= String.format("Delete from product where ProductId = '%d' ", productId);
			String sql1=String.format("SELECT * FROM product WHERE ProductId = '%d' ", productId);
			Product product= new Product();
			Category category= new Category();
			int categoryId=0;
			ResultSet resultSet= statement.executeQuery(sql1);
			if(resultSet.next()) {
				product.setProductId(resultSet.getInt("ProductId"));
				product.setCode(resultSet.getString("ProductCode"));
				product.setDescription(resultSet.getString("Description"));
				product.setName(resultSet.getString("Name"));
				product.setPrice(resultSet.getInt("Price"));
				categoryId=resultSet.getInt("Category");
				String s=String.format("Select * from category where categoryId = '%d'", categoryId);
				ResultSet resultSet1= statement1.executeQuery(s);
				if(resultSet1.next()) {
					category.setCategoryName(resultSet.getString(1));
					category.setCategoryId(categoryId);
				}
				product.setCategory(category);
				statement.execute(sql);
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with Code %d not found", productId)));
	}
	
	public Product updateProduct(Product product) throws ProductNotFoundException{
		try {
			statement= connection.createStatement();
			String sql1= String.format("SELECT * FROM product WHERE ProductId = '%d' ", product.getProductId());
			String sql= String.format("Update product set productCode = '%s', name ='%s',description='%s', price = '%d', category='%d' where productId = '%d'", 
							product.getCode(), product.getName(),product.getDescription(),product.getPrice(),product.getCategory().getCategoryId(),product.getProductId());
			ResultSet rs= statement.executeQuery(sql1);
			if(rs.next()) {
				statement.execute(sql);
				return product;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new ProductNotFoundException(new ExceptionMessage(String.format("Product with Id %d not found", product.getProductId())));
		
	}
}	
	
