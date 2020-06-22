package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import com.order.bean.Category;
import com.order.bean.Order;
import com.order.bean.Product;
import com.order.bean.User;

public class OrderDataFetch {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			connection=dc.createConnection();
	}
	
	public ArrayList<Order> getAllOrders(){
		ArrayList<Order>or= new ArrayList<Order>();
		try {
			statement= connection.createStatement();
			Statement statement1= connection.createStatement();
			String sql= String.format("Select * from orders");
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				Order o= new Order();
				o.setOrderId(rs.getInt("OrderId"));
				o.setNumber(rs.getString("orderNum"));
				o.setOrderedOn(rs.getDate("OrderedOn"));
				//o.setStatus(OrderStatus.valueOf(rs.getString("status")));
				o.setTotalAmount(rs.getInt("amount"));
				int userId=rs.getInt("OrderedBy");
				//System.out.println(userId);
				String sql2=String.format("SELECT * FROM user where userid='%d'",userId);
				Statement statement3=connection.createStatement();
				ResultSet rs1=statement3.executeQuery(sql2);
				User user=new User();
				if(rs1.next()==true)
				{
					user.setId(rs1.getInt("userid"));
					user.setName(rs1.getString("name"));
					//System.out.println(user.getName());
					user.setEmail(rs1.getString("email"));
					user.setPassword(rs1.getString("password"));
					user.setAddress(rs1.getString("address"));
					user.setPhone(rs1.getString("phone"));
				}
				
				o.setOrderedBy(user);
				
				String sql1= String.format("Select * from product where ProductId in(Select ProductId from items where OrderId = '%d')",o.getOrderId());
				ResultSet resultSet= statement1.executeQuery(sql1);
				
				HashSet<Product>pr= new HashSet<Product>();
				while(resultSet.next()) {
					Product product= new Product();
					Category category= new Category();
					product.setProductId(resultSet.getInt("ProductId"));
					product.setCode(resultSet.getString("ProductCode"));
					product.setDescription(resultSet.getString("Description"));
					product.setName(resultSet.getString("Name"));
					product.setPrice(resultSet.getInt("Price"));
					int categoryId=resultSet.getInt("Category");
					Statement statement2=connection.createStatement();
					sql=String.format("Select * from category where categoryId = '%d'", categoryId);
					ResultSet resultSet1= statement2.executeQuery(sql);
					if(resultSet1.next()) {
						category.setCategoryName(resultSet1.getString("CategoryName"));
						category.setCategoryId(categoryId);
					}
					product.setCategory(category);
					pr.add(product);
				}
				o.setCart(pr);
				or.add(o);
			}
			return or;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return null;
		
	}
}
