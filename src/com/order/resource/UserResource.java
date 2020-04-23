package com.order.resource;

import javax.ws.rs.Path;

import java.sql.SQLException;
import java.util.ArrayList;

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

import com.order.bean.User;
import com.order.exception.UserNotFoundException;
import com.order.util.DataFetch;

@Path("/user")
public class UserResource 
{
	@Context 
	private ResourceContext resourceContext;
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("/{userId}")   
	public Response getUser(@PathParam("userId") int userId) throws UserNotFoundException {
		User user= null;
		user= new DataFetch().getUser(userId);
		return Response.ok(user).build();
	}
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("/all-users")   
	public ArrayList<User> getAllUsers(@PathParam("userId") int userId) throws UserNotFoundException {
		return new DataFetch().getAllUsers();
	}
	
	 @POST
	 @Consumes(value={MediaType.APPLICATION_JSON})
	 public void createUser(User user) throws UserNotFoundException,SQLException { 
		 new DataFetch().addUser(user);
	 }
	 
	 @PUT
	 @Consumes(value= {MediaType.APPLICATION_JSON})
	 @Path("/{userId}/update_email/{email}")
	 public void updateUserEmail(@PathParam("userId")int userId, 
			 					 @PathParam("email")String email)throws UserNotFoundException, SQLException {
		 new DataFetch().updateUserEmail(userId, email);
	 }
	 
	 @PUT
	 @Consumes(value= {MediaType.APPLICATION_JSON})
	 @Path("/{userId}/update_name/{name}")
	 public void updateUserName(@PathParam("userId")int userId, 
			 					 @PathParam("name")String name)throws UserNotFoundException, SQLException {
		 new DataFetch().updateUserEmail(userId, name);
	 }
	 
	 @PUT
	 @Consumes(value= {MediaType.APPLICATION_JSON})
	 @Path("/{userId}/update_number/{phone}")
	 public void updateUserPhone(@PathParam("userId")int userId, 
			 					 @PathParam("phone")int phone)throws UserNotFoundException, SQLException {
		 new DataFetch().updateUserPhone(userId, phone);
	 }
	 
	 @PUT
	 @Consumes(value= {MediaType.APPLICATION_JSON})
	 @Path("/{userId}/update_address/{address}")
	 public void updateUserAddress(@PathParam("userId")int userId, 
			 					 @PathParam("address")String address)throws UserNotFoundException, SQLException {
		 new DataFetch().updateUserAddress(userId, address);
	 }
	 
	 @PUT
	 @Consumes(value= {MediaType.APPLICATION_JSON})
	 @Path("/{userId}/update_password/{password}")
	 public void updateUserPassword(@PathParam("userId")int userId, 
			 					 @PathParam("password")String password)throws UserNotFoundException, SQLException {
		 new DataFetch().updateUserPassword(userId, password);
	 }
	 
	 @DELETE
	 @Path("/{userId}/delete-user")
	 public void deleteUser(@PathParam("userId")int userId) throws UserNotFoundException, SQLException {
		 new DataFetch().deleteUser(userId);
		 
	 }
	 
	 
	 
	
}
