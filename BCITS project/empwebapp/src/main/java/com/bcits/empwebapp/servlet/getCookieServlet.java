package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getCookie")
public class getCookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookies[] =req.getCookies();
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(cookies != null) {
		for (Cookie cookie : cookies) {
			out.println("<h2>Cookie Name : "+cookie.getName());
			out.println("<br> Cookie Value : "+cookie.getValue()+"</h2>");
		}
		}else {
			out.println("<h2 style='color:red;'>Cookie Not Found ..</h2>");
		}
		out.println("</body>");
		out.println("</html>");
		
	}
}
