package com.order.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.order.bean.Product;
import com.order.Exception.ProductAlreadyExist;
import com.order.Exception.ProductNotFoundException;
import com.order.util.ProductDataFetch;

@Path("/products")
public class ProductResource 
{
	@Context
	private ResourceContext resourceContext;
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/{productId}")   
	public Response getProduct(@PathParam("productId") int productId) throws ProductNotFoundException, SQLException {
		Product product= new ProductDataFetch().getProduct(productId);
		return Response.ok(product).build();
	}
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/all-products")   
	public ArrayList<Product> getAllProducts() throws ProductNotFoundException, SQLException {
		return new ProductDataFetch().getAllProducts();
		
	}
	
	@POST
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/add-product")
	 public Response addProduct(Product product) throws SQLException, ProductAlreadyExist { 
		 Product pr=new ProductDataFetch().addProduct(product);
		 return Response.ok(pr).build();
	 }
	
	 @DELETE
	 @Produces(value={MediaType.APPLICATION_JSON})
	 @Consumes(value={MediaType.APPLICATION_JSON})
	 @Path("/delete-product/{productId}")
	 public Response deleteProduct(@PathParam("productId")int productId) throws ProductNotFoundException, SQLException {
		 Product product=null;
				 product=new ProductDataFetch().deleteProduct(productId);
		 return Response.ok(product).build();
	 }
	 
	 @PUT
	 @Path("/update-product")
	 @Produces(value={MediaType.APPLICATION_JSON})
	 @Consumes(value= MediaType.APPLICATION_JSON)
	 public Response updateProduct(Product product) throws ProductNotFoundException {
		Product pr=new ProductDataFetch().updateProduct(product);
		return Response.ok(pr).build();
		 
	 }
}
