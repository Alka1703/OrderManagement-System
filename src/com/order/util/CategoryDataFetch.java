package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.order.bean.Category;
import com.order.Exception.CategoryAlreadyExist;
import com.order.Exception.CategoryNotFoundException;
import com.order.Exception.ExceptionMessage;

public class CategoryDataFetch {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			connection=dc.createConnection();
	}
	
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
				return category;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new CategoryNotFoundException(new ExceptionMessage(String.format("Category with ID %d not found", categoryId)));
	}
	
	public Category addCategory(Category category) throws CategoryAlreadyExist {
		try {
			statement= connection.createStatement();
			String sql,s;
			s=String.format("Select * from Category where categoryId = '%d'", category.getCategoryId());
			ResultSet rs= statement.executeQuery(s);
			if(rs.next()) {
				throw new CategoryAlreadyExist(new ExceptionMessage(String.format("Category with ID %d already Exists", category.getCategoryId())));
			}
			sql= String.format("Insert into Category values ('%d', '%s')", category.getCategoryId(), category.getCategoryName());
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
	
	public Category deleteCategory(int categoryId) throws CategoryNotFoundException{
		try {
			statement= connection.createStatement();
			ResultSet resultSet;
			String sql;
			Category category= new Category();
			sql= String.format("Select * from Category where categoryId = '%d'", categoryId);
			resultSet= statement.executeQuery(sql);
			if(resultSet.next()) {
				category.setCategoryId(categoryId);
				category.setCategoryName(resultSet.getString("categoryName"));
				sql= String.format("Delete from Category where CategoryId= '%d'", categoryId);
				statement.execute(sql);
				return category;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		throw new CategoryNotFoundException(new ExceptionMessage(String.format("Category with ID %d not found", categoryId)));
	}
	
	public ArrayList<Category> fetchAllCategory() throws CategoryNotFoundException {
		ArrayList<Category>category= new ArrayList<Category>();
		try {
			statement= connection.createStatement();
			String sql= String.format("Select * from category");
			ResultSet resultSet= statement.executeQuery(sql);
			while(resultSet.next()) {
				Category c= new Category();
				c.setCategoryId(resultSet.getInt("CategoryId"));
				c.setCategoryName(resultSet.getString("CategoryName"));
				category.add(c);
			}
			if(category.size()==0)
				throw new CategoryNotFoundException(new ExceptionMessage("No Category Found"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return category;
	}
	
		
	public Category updateCategory(Category category) throws CategoryNotFoundException {
		try {
			statement=connection.createStatement();
			
			String sql1=String.format("select * from category where CategoryId='%d'",category.getCategoryId());
			String sql=String.format("Update  category set categoryName = '%s' where CategoryId =  '%d' ",category.getCategoryName(),category.getCategoryId());;
			
			ResultSet rs=statement.executeQuery(sql1);
			if(rs.next())
			{
				statement.execute(sql);
				return category;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		throw new CategoryNotFoundException(new ExceptionMessage(String.format("Category with ID %d not found", category.getCategoryId())));
	
	}
}	
	
