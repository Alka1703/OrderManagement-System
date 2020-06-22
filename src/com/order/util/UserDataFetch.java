package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.order.Exception.ExceptionMessage;
import com.order.Exception.UserAlreadyExist;
import com.order.Exception.UserNotFoundException;
import com.order.bean.User;

public class UserDataFetch {
	
	private static Connection conn;
	static {
		DatabaseConnection db=new DatabaseConnection();
		conn=db.createConnection();
		
	}
	public User getUser(int userId) throws UserNotFoundException 
	{
		try {
			
			String sql=String.format("SELECT * FROM user where userid='%d'",userId);
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs1=statement.executeQuery(sql);
			if(rs1.next()==true)
			{
				User user=new User();
				user.setId(rs1.getInt("userid"));
				user.setName(rs1.getString("name"));
				//System.out.println(user.getName());
				user.setEmail(rs1.getString("email"));
				user.setPassword(rs1.getString("password"));
				user.setAddress(rs1.getString("address"));
				user.setPhone(rs1.getString("phone"));
			return user;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String temp=String.format("User of userId %d not found",userId);
		throw new UserNotFoundException(new ExceptionMessage(temp));
		
	}
	
	public User createUser(User user) throws UserAlreadyExist
	{
		try {
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql1=String.format("select * from user where userid='%d'",user.getId());
			String sql=String.format("INSERT INTO user values('%d','%s','%s','%s','%s','%s')",user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getAddress(),user.getPhone());
			boolean flag=false;
			ResultSet rs=statement.executeQuery(sql1);
			if(rs.next())
			{
				flag=true;
				
			}
			if(flag==true)
			{
				String temp=String.format("User of userId %d already exist",user.getId());
				throw new UserAlreadyExist(new ExceptionMessage(temp));
			}
			else
			{
				statement.execute(sql);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	public ArrayList<User> getAllUser() throws UserNotFoundException
	{
		ArrayList<User> arr=new ArrayList<User>();
		try {
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			String sql = "SELECT * from user";
			ResultSet rs=statement.executeQuery(sql);
			
			while(rs.next())
			{
				User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhone(rs.getString(6));
				arr.add(user);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(arr.size());
		if(arr.size()==0)
		{
			String temp="No users found";
			
			throw new UserNotFoundException(new ExceptionMessage(temp));
		}
		return arr;
		
	}
	public User deleteUser(int userId) throws UserNotFoundException
	{

		try {
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
			String sql= String.format("Delete from user where userid = '%d' ", userId);
			String sql1=String.format("select * from user where userid='%d'",userId);
			ResultSet rs=statement.executeQuery(sql1);
			if(rs.next())
			{
				 User user=new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setAddress(rs.getString(5));
				user.setPhone(rs.getString(6));
				statement.execute(sql);
				return user;
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String temp=String.format("User with %d user doesnot exist",userId);
		throw new UserNotFoundException(new ExceptionMessage(temp));	
	}
	
	public User updateUser(User user) throws UserNotFoundException
	{
		try {
			Statement statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			String sql1=String.format("select * from user where userid='%d'",user.getId());
			String sql=String.format("Update  user set name = '%s',email ='%s',password ='%s',address ='%s',phone ='%s' where userid = '%d'",user.getName()
					,user.getEmail(),user.getPassword(),user.getAddress(),user.getPhone(),user.getId());
			
			ResultSet rs=statement.executeQuery(sql1);
			if(rs.next())
			{
				statement.execute(sql);
				return user;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String temp=String.format("User with %d userId doesnot exist",user.getId());
		throw new UserNotFoundException(new ExceptionMessage(temp));
	}
}
