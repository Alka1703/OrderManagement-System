package com.order.util;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.order.Exception.OrderExceptionMapper;
import com.order.resource.BusinessChartResource;
import com.order.resource.CategoryResource;
import com.order.resource.OrderResource;
import com.order.resource.PopularProductResource;
import com.order.resource.ProductResource;
import com.order.resource.StockResource;
import com.order.resource.UserResource;
@ApplicationPath("/home")
public class OrderApplication  extends Application {
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes;
		
		classes =new HashSet<Class<?>>();
		classes.add(UserResource.class);
		classes.add(ProductResource.class);
		classes.add(CategoryResource.class);
		classes.add(StockResource.class);
		classes.add(BusinessChartResource.class);
		classes.add(OrderResource.class);
		classes.add(PopularProductResource.class);
		classes.add(OrderExceptionMapper.class);
		return classes;
		
	}
}
