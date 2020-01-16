package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/craeteCookie")
public class CreateCookieServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie myCookie = new Cookie("empName", "Sam");
		myCookie.setMaxAge(7 * 24 * 60 * 60); //making cookie persistent for 7 days
		resp.addCookie(myCookie);

		PrintWriter out = resp.getWriter();
		out.println("<h1 style ='color:green;'>Cookies Created Sucessfully.. </h1> <br>");

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./cookiePage.html");
		requestDispatcher.include(req, resp);
	}
}
