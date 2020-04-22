package com.order.resource;

import javax.ws.rs.Path;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.order.bean.User;
import com.order.exception.UserNotFoundException;
import com.order.util.DataFetch;

@Path("/users")
public class UserResource //Root Resource Class
{
	@Context 
	private ResourceContext resourceContext;
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("/{userId}")   
	public Response getUser(@PathParam("userId") int userId) throws UserNotFoundException, SQLException {
		User user= new DataFetch().getUser(userId);
		return Response.ok(user).build();
	}
	
	 @POST
	 @Consumes(value={MediaType.APPLICATION_JSON})
	 public void createUser(User user) throws SQLException { 
		 new DataFetch().addUser(user);
	 }
	 
	 @PUT
	 @Consumes(value= {MediaType.APPLICATION_JSON})
	 @Path("/{userId}/update_email/{email}")
	 public void updateUserEmail(@PathParam("userId")int userId, 
			 					 @PathParam("email")String email)throws UserNotFoundException, SQLException {
		 System.out.println("update");
		 new DataFetch().updateUserEmail(userId, email);
	 }
	 @DELETE
	 @Path("/{userId}/delete-user")
	 public void deleteUser(@PathParam("userId")int userId) throws UserNotFoundException, SQLException {
		 new DataFetch().deleteUser(userId);
		 
	 }
	 
	 
	 
	
}
