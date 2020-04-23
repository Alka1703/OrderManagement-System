package com.order.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.order.Exception.OrderExceptionMapper;
import com.order.resource.UserResource;
@ApplicationPath("/home")
public class OrderApplication  extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes;
		
		classes =new HashSet<Class<?>>();
		classes.add(UserResource.class);
		classes.add(OrderExceptionMapper.class);
		return classes;
		
	}
}
