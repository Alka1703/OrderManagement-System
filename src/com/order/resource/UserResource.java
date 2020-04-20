package com.order.resource;

import javax.ws.rs.Path;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
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
	//dependency injection
	@Context //Jersey Container will initialize the variable on my behalf
	private ResourceContext resourceContext;
	
	@Context
	private UriInfo uriInfo;
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Path("{userId}")   
	public Response fetchUserDetails(@PathParam("userId") int userId) throws UserNotFoundException, SQLException
	{
		System.out.println("User Resource");
		User user;
		user=new DataFetch().getUser(userId);
		return Response.ok(user).build(); 
	}
	
	@POST
	@Consumes(value={MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public void createUser(User user) throws SQLException
	{
		new DataFetch().addUser(user);
	}
	
}
