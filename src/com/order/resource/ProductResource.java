package com.order.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.order.bean.Product;
import com.order.exception.ProductNotFoundException;

@Path("/products")
public class ProductResource 
{
	@Context //Jersey Container will initialize the variable on my behalf
	private ResourceContext resourceContext;
	
	@Context
	private UriInfo uriInfo;
	/*
	 * 
	 * @GET
	 * 
	 * @Produces(value={MediaType.APPLICATION_JSON})
	 * 
	 * @Path("{prod}") //template parameter public Response
	 * fetchProductDetails(@PathParam("prod") String prod) throws
	 * ProductNotFoundException, SQLException { Product product; //product=new
	 * TiendaService().getProductDetails(prod); return Response.ok(product).build();
	 * //can be applied to all functions }
	 * 
	 * @PUT
	 * 
	 * @Consumes(value={MediaType.APPLICATION_JSON}) public void addProduct(Product
	 * prod) throws SQLException { new TiendaService().addProduct(prod); }
	 * 
	 * 
	 */
}
