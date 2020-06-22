package com.order.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.order.bean.Product;
import com.order.util.PopularProductDataFetch;

@Path("/popular-products") 
public class PopularProductResource {

	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	
	public ArrayList<Product>getPopularProduct() throws SQLException{
		return new PopularProductDataFetch().getPopularProducts();
	}
}
