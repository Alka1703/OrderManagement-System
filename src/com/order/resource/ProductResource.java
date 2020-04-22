package com.order.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.order.bean.Product;
import com.order.exception.ProductNotFoundException;
import com.order.util.DataFetch;

@Path("/product")
public class ProductResource 
{
	@Context
	private ResourceContext resourceContext;
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("/{productId}")   
	public Response getProduct(@PathParam("productId") int productId) throws ProductNotFoundException, SQLException {
		Product product= new DataFetch().getProduct(productId);
		return Response.ok(product).build();
	}
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("/all-products")   
	public ArrayList<Product> getAllProducts(@PathParam("productId") int productId) throws ProductNotFoundException, SQLException {
		return new DataFetch().getAllProducts();
		
	}
	
	@POST
	 @Consumes(value={MediaType.APPLICATION_JSON})
	 public void addProduct(Product product) throws SQLException { 
		 new DataFetch().addProduct(product);
	 }
	
	 @DELETE
	 @Path("/delete-product/{productId}")
	 public void deleteProduct(@PathParam("productId")int productId) throws ProductNotFoundException, SQLException {
		 new DataFetch().deleteProduct(productId);
	 }
}
