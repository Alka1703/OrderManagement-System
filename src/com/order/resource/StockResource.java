package com.order.resource;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.order.Exception.StockNotFoundException;
import com.order.bean.Sell;
import com.order.bean.Stock;
import com.order.util.StockDataFetch;

@Path("/stock")
public class StockResource {
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/sell-details")
	public ArrayList<Sell> getSellDetails() throws StockNotFoundException {
		ArrayList<Stock>stock = new ArrayList<Stock>();
		ArrayList<Integer>temp= new ArrayList<>();
		
		stock= new StockDataFetch().getStockDetails();
		LinkedHashMap<Integer,Integer>stk= new LinkedHashMap<Integer, Integer>();
		for(Stock s: stock) {
			if(stk.containsKey(s.getCategoryId())) {
				int val=stk.get(s.getCategoryId());
				val=val+s.getStock();
			}
			else {
				stk.put(s.getCategoryId(), s.getStock());
				temp.add(s.getCategoryId());
			}
		}
		ArrayList<Sell>sell= new ArrayList<Sell>();
		for(int i:temp) {
			Sell s= new Sell();
			s.setCategoryId(i);
			s.setQty(stk.get(i));
			sell.add(s);
		}
		
		return sell;
	}

}
