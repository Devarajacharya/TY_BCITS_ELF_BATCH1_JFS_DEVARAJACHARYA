package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/include")
public class IncludeServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String url = "./currentDate";
//	String url = "./date.html";
//	String url = "https://www.youtube.com";   //(We Can't Forward to External Resource)

	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<body>");
    out.println("<h1 style='color:blue;'>Hello World</h1>");
	out.println("<body>");
	out.println("<html>");

	RequestDispatcher requestDispatcher = req.getRequestDispatcher(url);
	requestDispatcher.include(req, resp);
}
}
