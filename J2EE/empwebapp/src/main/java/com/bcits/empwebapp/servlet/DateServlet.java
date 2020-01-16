package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		resp.setHeader("refresh", "1");
		
		//Getting Config Parameter
		ServletConfig config = getServletConfig();
		String myconfigParam =config.getInitParameter("servletName");
		
		//Getting Context Parameter
		ServletContext context =getServletContext();
		String myContentPram= context.getInitParameter("appName");
		
		// code to generate dynamic response
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1> Current System Date & Tine is :- " + date + "</h1>");
		out.println("<h2 style ='color:red;'>Servlet Name = "+myconfigParam+"</h2>");
		out.println("<h2 style ='color:green;'>Application Name = "+myContentPram+"</h2>");
		out.println("</body>");
		out.println("</html>");

//		out.println("Current System Date & Time is :"+date);

	}
}
