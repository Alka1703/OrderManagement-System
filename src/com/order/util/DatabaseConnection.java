package com.order.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private  Connection conn=null;
	static{
		try {
			System.out.println("hiih");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public  Connection createConnection() throws SQLException{
		
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/oms_db","root","alka@1703");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("dbconnection");
		return conn;
	}
	public  void closeConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
