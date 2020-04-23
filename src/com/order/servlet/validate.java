/*
 * This class will reside inside the package com.order.servlet inside the src folder.
 * This class will take the parameters from the html form, validate them and send them to 
 * the java class.
 * */
package com.order.servlet;
import com.order.util.DataFetch;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.bean.User;
import com.order.exception.UserNotFoundException;
public class validate extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		User user = new User();
		
		// values from the dto will be called in the servlet
		user.setName(uname);
		user.setAddress(address);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(Integer.parseInt(phone));
		
		
		//Now create an object of Data fetch to pass these values
		//This line will show an error because you will have to import the dataFetch class in this file
		DataFetch fetch = new DataFetch();
		try {
			fetch.addUser(user);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("AfterSignup.html");
		
	}
}
