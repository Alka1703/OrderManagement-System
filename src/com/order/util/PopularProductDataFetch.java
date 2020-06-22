package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import com.order.bean.Category;
import com.order.bean.Product;

public class PopularProductDataFetch {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			connection=dc.createConnection();
	}
	public Product getProduct(int productId) {
		try {
			statement= connection.createStatement();
			Statement statement1= connection.createStatement();
			ResultSet resultSet,resultSet1;
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
				
				sql=String.format("Select * from category where categoryId = '%d'", categoryId);
				resultSet1= statement1.executeQuery(sql);
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
		return null;
		
	}

	public ArrayList<Product> getPopularProducts() throws SQLException {
		//SELECT CURRENT_DATE()
		//SELECT DATE_SUB("2017-06-15", INTERVAL 30 DAY); 
		LinkedHashMap<Integer, Integer>map= new LinkedHashMap<Integer, Integer>();
		statement=connection.createStatement();
		String sql=String.format("SELECT CURRENT_DATE()");
		ResultSet rs= statement.executeQuery(sql);
		String endDate="";
		if(rs.next())
			endDate=rs.getString(1);
		sql=String.format("SELECT DATE_SUB('%s', INTERVAL 200 DAY)",endDate);
		rs=statement.executeQuery(sql);
		String startDate="";
		if(rs.next())
			startDate=rs.getString(1);
		
		sql= String.format("Select ProductId from items where orderId in (Select orderId from Orders where OrderedOn between '%s' and '%s')",startDate, endDate);
		rs= statement.executeQuery(sql);
		while(rs.next()) {
			int key=rs.getInt(1);
			if(map.containsKey(key)) 
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}
		
		 List<Map.Entry<Integer, Integer> > list = 
	               new LinkedList<Map.Entry<Integer, Integer> >(map.entrySet()); 
	  
	        // Sort the list 
	        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() { 
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					return (o2.getValue()).compareTo(o1.getValue());
				} 
	        });
	        ArrayList<Product>pr = new ArrayList<Product>();
	        int size=list.size();
	        int count = size > 10 ? 10 : size; 
	        System.out.println(count);
	        int i=0;
	        for (Map.Entry<Integer, Integer> aa : list) { 
	            if(i<count) {
	            	Product p= null;
	            	p=getProduct(aa.getKey());
	            	if(p!=null) {
	            		pr.add(p);
	            		i++;
	            	}
	            }
	        }
	        return pr;
	
		
	}
}
