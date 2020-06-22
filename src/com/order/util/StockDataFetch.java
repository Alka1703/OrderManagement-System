package com.order.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.order.Exception.ExceptionMessage;
import com.order.Exception.StockNotFoundException;
import com.order.bean.Stock;

public class StockDataFetch {
	static Connection connection=null;
	Statement statement=null;
	static {
		DatabaseConnection dc= new DatabaseConnection();
			connection=dc.createConnection();
	}
	
	public ArrayList<Stock> getStockDetails() throws StockNotFoundException {
		try {
			statement=connection.createStatement();
			ArrayList<Stock>st= new ArrayList<>();
			String sql =String.format("Select * from stock");
			ResultSet rs= statement.executeQuery(sql);
			while(rs.next()) {
				Stock stock= new Stock();
				stock.setProductId(rs.getInt("ProductId"));
				stock.setStock(rs.getInt("StockAmount"));
				stock.setCategoryId(rs.getInt("CategoryId"));
				st.add(stock);
			}
			return st;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new StockNotFoundException(new ExceptionMessage("No Stock Found"));
	}
}
