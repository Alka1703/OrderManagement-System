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

import com.order.bean.Category;
import com.order.exception.CategoryNotFoundException;
import com.order.util.DataFetch;

@Path("/category") 
public class CategoryResource {
	
	@Context
	private ResourceContext resourceContext;

	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("/all-categories")   
	public ArrayList<Category> fetchAllCategory() throws CategoryNotFoundException, SQLException {
		return new DataFetch().fetchAllCategory();	
	}
	 
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("/get-category/{categoryId}")   
	public  Category getProduct(@PathParam("categoryId") int categoryId) throws CategoryNotFoundException, SQLException {
		return new DataFetch().getCategory(categoryId);	
	}
	
	 @POST
	 @Consumes(value={MediaType.APPLICATION_JSON})
	 @Path("/add-category")
	 public void addCategory(Category category) throws SQLException { 
		 new DataFetch().addCategory(category);
	 }
	
	 @DELETE
	 @Path("/delete-category/{categoryId}")
	 public void deleteCategory(@PathParam("categoryId")int categoryId) throws CategoryNotFoundException, SQLException {
		 new DataFetch().deleteCategory(categoryId);
	 }
	 
	
}
