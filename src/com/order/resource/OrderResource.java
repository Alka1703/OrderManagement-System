package com.order.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.order.bean.Order;
import com.order.util.OrderDataFetch;
@Path("/all-orders") 
public class OrderResource {
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	public ArrayList<Order> getAllOrder() {
		//ArrayList<Order>order= new ArrayList<>();
		return new OrderDataFetch().getAllOrders();
	
		
	}
}
