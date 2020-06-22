package com.order.resource;

import java.util.Random;

public class Data {
	public static void main(String[] args) {
		Random rand = new Random(); 
		 for(int i=501;i<=540;i++) {
			 int p=rand.nextInt(5);
			 while(p==0) {
				 p=rand.nextInt(5);
			 }
			 for (int j=1;j<=p;j++) {
				 int pr=rand.nextInt(41);
				 while(pr==0) {
					 pr=rand.nextInt(41);
				 }
				 System.out.println("INSERT INTO items VALUES ("+i+", "+pr+");");
			 }
		 }
	}
}
