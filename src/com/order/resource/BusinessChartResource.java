package com.order.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.order.Exception.DataNotFoundException;
import com.order.bean.Dummy;
import com.order.util.BusinessChartDataFetch;

@Path("/business-chart")
public class BusinessChartResource {

	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/monthly-data/{year}/{month}") 
	public Response fetchMonthlyBusinessChartData( @PathParam("month") int month,@PathParam("year")int year) throws DataNotFoundException {
		
		System.out.println(month+ " "+year);
		Integer amount=new BusinessChartDataFetch().monthlyBusinessChart(month, year);
		
		Dummy d= new Dummy();
		d.setAmount(amount);
		return Response.ok(d).build();
		//return d;
	}
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/yearly-data/{year}") 
	public Dummy fetchYearlyBusinessChartData(@PathParam("year")int year) throws DataNotFoundException {
		Integer amount=new BusinessChartDataFetch().yearlyBusinessChart(year);
		Dummy d= new Dummy();
		d.setAmount(amount);
		return d;
	}
	
	@GET
	@Produces(value={MediaType.APPLICATION_JSON})
	@Consumes(value={MediaType.APPLICATION_JSON})
	@Path("/quarterly-data/{startMonth}/{endMonth}/{year}") 
	public Dummy fetchQuarterlyBusinessChartData( @PathParam("startMonth") int startMonth,@PathParam("endMonth")int endMonth,@PathParam("year")int year) throws DataNotFoundException {
		Integer amount=new BusinessChartDataFetch().quarterlyBusinessChart(startMonth, endMonth,year);
		Dummy d= new Dummy();
		d.setAmount(amount);
		return d;
	}
	
	
}
