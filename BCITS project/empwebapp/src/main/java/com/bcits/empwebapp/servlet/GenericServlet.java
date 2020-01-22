package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/myGenericServlet")
public class GenericServlet extends  javax.servlet.GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String eName =req.getParameter("eName");
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1 style ='color:green;'>Welcome To Generic Servlet </h1>");
		out.println("<h2 style ='color:red;'>Employee Id = "+eName+"</h2>");
		out.println("</body>");
		out.println("</html>");
		
	}

}
