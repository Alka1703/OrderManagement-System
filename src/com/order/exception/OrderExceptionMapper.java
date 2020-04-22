package com.order.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class OrderExceptionMapper implements ExceptionMapper<OrderManagementException>{

	@Override
	public Response toResponse(OrderManagementException ex) {
		
		return Response.status(Response.Status.BAD_REQUEST).entity(ex.getExceptionMessage()).build();
	}
	

}
