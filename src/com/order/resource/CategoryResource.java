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
import com.order.bean.Category;
import com.order.Exception.CategoryAlreadyExist;
import com.order.Exception.CategoryNotFoundException;
import com.order.util.CategoryDataFetch;

@Path("/category") 
public class CategoryResource {
	
	@Context
	private ResourceContext resourceContext;

	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/all-categories")   
	public ArrayList<Category> fetchAllCategory() throws CategoryNotFoundException, SQLException {
		return new CategoryDataFetch().fetchAllCategory();	
	}
	 
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/get-category/{categoryId}")   
	public  Category getProduct(@PathParam("categoryId") int categoryId) throws CategoryNotFoundException, SQLException {
		return new CategoryDataFetch().getCategory(categoryId);	
	}
	
	 @POST
	 @Produces(value={MediaType.APPLICATION_JSON})
	 @Consumes(value={MediaType.APPLICATION_JSON})
	 @Path("/add-category")
	 public Response addCategory(Category category) throws SQLException, CategoryAlreadyExist { 
		 Category cr= new CategoryDataFetch().addCategory(category);
		 return Response.ok(cr).build();
	 }
	
	 @DELETE
	 @Produces(value={MediaType.APPLICATION_JSON})
	 @Consumes(value={MediaType.APPLICATION_JSON})
	 @Path("/delete-category/{categoryId}")
	 public Response deleteCategory(@PathParam("categoryId")int categoryId) throws CategoryNotFoundException, SQLException {
		 Category cr=new CategoryDataFetch().deleteCategory(categoryId);
		 return Response.ok(cr).build();
	 }
	 
	 @PUT
	 @Path("/update-category")
	 @Produces(value={MediaType.APPLICATION_JSON})
	 @Consumes(value= MediaType.APPLICATION_JSON)
	 public Response updateCategory(Category category) throws CategoryNotFoundException {
		 System.out.println(category.getCategoryId());
		 Category cr= new CategoryDataFetch().updateCategory(category);
		return Response.ok(cr).build();
		 
	 }
	 
	
}
