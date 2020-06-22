package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.order.Exception.DataNotFoundException;
import com.order.Exception.ExceptionMessage;

public class BusinessChartDataFetch {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			connection=dc.createConnection();
	}
	
	public int monthlyBusinessChart(int month,int year) throws DataNotFoundException {
		//SELECT * FROM Orders WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31';
		int amount=0;
		try {
			statement=connection.createStatement();
			
			String startDate, endDate;
			if(month<10) {
				startDate=year+"-0"+month+"-01";
				if(month==1 || month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12) 
					endDate=year+"-0"+month+"-31";
				else 
					endDate=year+"-0"+month+"-30";
			}
			else {
				startDate=year+"-"+month+"-01";
				if(month==1 || month==3 ||month==5 ||month==7 ||month==8 ||month==10 ||month==12) 
					endDate=year+"-"+month+"-31";
				else 
					endDate=year+"-"+month+"-30";
			}
			
			String sql= String.format("Select amount from Orders where OrderedOn between '%s' and '%s'",startDate, endDate);
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next())
				amount=amount+ rs.getInt("amount");
			if(amount ==0)
				throw new DataNotFoundException(new ExceptionMessage("No orders were placed in the given time frame"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;	
	}

	public int yearlyBusinessChart(int year) throws DataNotFoundException {
		//SELECT * FROM Orders WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31';
		int amount=0;
		try {
			statement=connection.createStatement();
			
			String startDate, endDate;
			startDate=year+"-01-01";
			endDate=year+"-12-31";
			
			String sql= String.format("Select amount from Orders where OrderedOn between '%s' and '%s'",startDate, endDate);
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next())
				amount=amount+ rs.getInt("amount");
			if(amount ==0)
				throw new DataNotFoundException(new ExceptionMessage("No orders were placed in the given time frame"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;	
	}
	
	public int quarterlyBusinessChart(int startMonth,int endMonth,int year) throws DataNotFoundException {
		//SELECT * FROM Orders WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31';
		int amount=0;
		try {
			statement=connection.createStatement();
			
			String startDate, endDate;
			if(startMonth<10) {
				startDate=year+"-0"+startMonth+"-01";
				if(endMonth==1 || endMonth==3 ||endMonth==5 ||endMonth==7 ||endMonth==8 ||endMonth==10 ||endMonth==12) 
					endDate=year+"-0"+endMonth+"-31";
				else 
					endDate=year+"-0"+endMonth+"-30";
			}
			else {
				startDate=year+"-"+startMonth+"-01";
				if(endMonth==1 || endMonth==3 ||endMonth==5 ||endMonth==7 ||endMonth==8 ||endMonth==10 ||endMonth==12) 
					endDate=year+"-"+endMonth+"-31";
				else 
					endDate=year+"-"+endMonth+"-30";
			}
			
			String sql= String.format("Select amount from Orders where OrderedOn between '%s' and '%s'",startDate, endDate);
			ResultSet rs= statement.executeQuery(sql);
			
			while(rs.next())
				amount=amount+ rs.getInt("amount");
			if(amount ==0)
				throw new DataNotFoundException(new ExceptionMessage("No orders were placed in the given time frame"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amount;	
	}
}
