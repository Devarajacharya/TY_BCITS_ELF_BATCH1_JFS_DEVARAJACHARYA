package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// Getting Context Parameter
		ServletContext context = getServletContext();
		String myContentPram = context.getInitParameter("appName");

		String id = req.getParameter("empId");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Emp Id : " + id + "</h2>");
		out.println("Emp Name = Prashul <br>");
		out.println("Emp Age = 10  <br>");
		out.println("Salary = 12000  <br>");
		out.println("Designation = SD  <br>");
		out.println("<h2 style ='color:green;'>Application Name = "+myContentPram+"</h2>");
		out.println("</body>");
		out.println("</html>");

	}
}
