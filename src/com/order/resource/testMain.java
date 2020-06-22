package com.order.resource;

import java.util.*;
import java.util.Random;

import com.order.bean.Order;
import com.order.bean.User;
import com.order.util.OrderDataFetch;

public class testMain {
	
	 public static java.util.LinkedList searchBetweenDates(java.util.Date startDate, java.util.Date endDate) 
	    {
	        java.util.Date begin = new Date(startDate.getTime());
	        java.util.LinkedList list = new java.util.LinkedList();
	        list.add(new Date(begin.getTime()));
	 
	        while(begin.compareTo(endDate)<0)
	        {
	            begin = new Date(begin.getTime() + 86400000);
	            list.add(new Date(begin.getTime()));
	        }
	 
	        return list;
	    }
	 
	    public static void main(String[] args) throws Exception   
	    {   
	        
	        String begin = new String();
	        begin = "01/01/2019";
	 
	        
	        String end = new String();
	        end = "31/05/2020";
	 
	        java.util.LinkedList hitList = searchBetweenDates(
	        	    new java.text.SimpleDateFormat("dd/MM/yyyy").parse(begin),
	        	    new java.text.SimpleDateFormat("dd/MM/yyyy").parse(end));
	 
	        String[] comboDates = new String[hitList.size()];
	        for(int i=0; i<hitList.size(); i++)
	            comboDates[i] = new java.text.SimpleDateFormat("yyyy-MM-dd").format(((java.util.Date)hitList.get(i)));
	 
	        for(int i=0; i<comboDates.length; i++)
	            System.out.println(comboDates[i]);
	 

		Random rand = new Random(); 
        int r1 = rand.nextInt(4);
        int r2=rand.nextInt(12);
        //int r3-rand.nextInt(comboDates.length);
        
        ArrayList<String>s= new ArrayList<String>();
        s.add("CONFIRMED");
        s.add("PACKED");
        s.add("BILLED");
        s.add("OUT_FOR_DELIVERY");
        
        ArrayList<Integer>a= new ArrayList<Integer>();
        for(int i=901;i<=912;i++)
        	a.add(i);
        
        for(int i=501;i<=540;i++) {
        	String st="OD1234"+i;
        	System.out.println("INSERT INTO orders VALUES ("+i+", '"+st+"', '"+ comboDates[rand.nextInt(comboDates.length)]+"', "+a.get(rand.nextInt(12))+", '"+s.get(rand.nextInt(4))+"', "+ rand.nextInt(5000)+");");
        }
	}
	

}
