<<<<<<< HEAD:src/com/order/servlet/checkLogin.java
package com.order.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.User;
import com.order.util.DataFetch;

public class checkLogin {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String password = request.getParameter("password");
		
		String email = request.getParameter("email");
		DataFetch df = new DataFetch();
		df.CheckLogin(email,  password);
		//response.sendRedirect("AfterSignup.html");
		
	}
}
=======
package com.order.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.util.DataFetch;

public class checkLogin {

	

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String password = request.getParameter("password");
		
		String email = request.getParameter("email");
		DataFetch df = new DataFetch();
		boolean value = df.CheckLogin(email,  password);
		if(value == true) {
			RequestDispatcher rd=request.getRequestDispatcher("Show.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		
	}
}
>>>>>>> 1d10f249e289a385c2bd7919e01e4ce9a9bce825:checkLogin.java
