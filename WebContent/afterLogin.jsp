<%@ page import="com.order.bean.Product" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.order.util.DataFetch" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome User</title>
</head>
<body>
	<div id="category">
		<ul><h1>GROCERY_AND_STAPLES</h1>
<%
	DataFetch df = new DataFetch();
	ArrayList<Product> results=(ArrayList<Product>)df.getAllProducts("GROCERY_AND_STAPLES");
	Iterator<Product> itr=results.iterator();
	while(itr.hasNext())
	{
		Product p=(Product)itr.next();
%>
			<l1><%= p.getName() %></l1>
		
		<% } %>
		</ul>
		
		
		
		<ul><h1>VEGETABLES_AND_FRUITS</h1>
<%
	DataFetch df2 = new DataFetch();
	ArrayList<Product> results2=(ArrayList<Product>)df.getAllProducts("VEGETABLES_AND_FRUITS");
	Iterator<Product> itr2=results.iterator();
	while(itr2.hasNext())
	{
		Product p2=(Product)itr2.next();
%>
			<l1><%= p2.getName() %></l1>
		
		<% } %>
		</ul>
		
		
		
		<ul><h1>PERSONAL_CARE</h1>
<%
	DataFetch df3 = new DataFetch();
	ArrayList<Product> results3=(ArrayList<Product>)df.getAllProducts("PERSONAL_CARE");
	Iterator<Product> itr3=results.iterator();
	while(itr3.hasNext())
	{
		Product p3=(Product)itr.next();
%>
			<l1><%= p3.getName() %></l1>
		
		<% } %>
		</ul>
		
		
		
		
		<ul><h1>HOUSEHOLD_ITEMS</h1>
<%
	DataFetch df4 = new DataFetch();
	ArrayList<Product> results4=(ArrayList<Product>)df.getAllProducts("HOUSEHOLD_ITEMS");
	Iterator<Product> itr4=results.iterator();
	while(itr4.hasNext())
	{
		Product p4=(Product)itr.next();
%>
			<l1><%= p4.getName() %></l1>
		
		<% } %>
		</ul>
		
		
		
		
		<ul><h1>HOME_AND_KITCHEN</h1>
<%
	DataFetch df5 = new DataFetch();
	ArrayList<Product> results5=(ArrayList<Product>)df.getAllProducts("HOME_AND_KITCHEN");
	Iterator<Product> itr5=results.iterator();
	while(itr5.hasNext())
	{
		Product p5=(Product)itr.next();
%>
			<l1><%= p5.getName() %></l1>
		
		<% } %>
		</ul>
		
		
		
		
		<ul><h1>BISCUITS_SNACKS_CHOCOLATES</h1>
<%
	DataFetch df6 = new DataFetch();
	ArrayList<Product> results6=(ArrayList<Product>)df.getAllProducts("BISCUITS_SNACKS_CHOCOLATES");
	Iterator<Product> itr6=results.iterator();
	while(itr6.hasNext())
	{
		Product p6=(Product)itr.next();
%>
			<l1><%= p6.getName() %></l1>
		
		<% } %>
		</ul>
	</div>
</body>
</html>