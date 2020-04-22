package com.order.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class OMSApplication extends Application{
	@Override
	public Set<Class<?>> getClasses() 
	{
		System.out.println("///");
		
		
		Set<Class<?>> classes;
		classes=new HashSet<Class<?>>();
		classes.add(UserResource.class);
		return classes;
	}
}