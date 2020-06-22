package com.order.resource;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.order.Exception.UserAlreadyExist;
import com.order.Exception.UserNotFoundException;
import com.order.bean.User;
//import com.order.util.DatabaseOperation;
import com.order.util.UserDataFetch;

@Path("/users")
public class UserResource{
	
	
	
	UserDataFetch db=new UserDataFetch();
	@POST
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response createUser(User user) throws UserAlreadyExist
	{
		db.createUser(user);
		return Response.ok(user).build();
	}
	
	
	
	@DELETE
	@Path("/{uid}")
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response deleteUser(@PathParam("uid")int userId) throws UserNotFoundException
	{
		User user=null;
		user=db.deleteUser(userId);
		return Response.ok(user).build();
	}
	
	
	
	@Path("/{uid}")
	@PUT
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response updateUserDetails(@PathParam("uid")int userId,User user) throws UserNotFoundException
	{
		  db.updateUser(user);
		  return Response.ok(user).build();
	}
	
	
	
	@GET
	@Path("/{uid}")
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Response getUser(@PathParam("uid")int userId) throws UserNotFoundException
	{
		
		User user=null;
		user=db.getUser(userId);
		return Response.ok(user).build();
		
		
	}
	
	
	
	@GET
	@Produces(value= {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public ArrayList<User> getAllUsers() throws UserNotFoundException
	{
		return db.getAllUser();
	}
	
	
	

}
