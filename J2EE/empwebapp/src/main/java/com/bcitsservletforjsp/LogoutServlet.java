package com.bcitsservletforjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutForm")
public class LogoutServlet extends HttpServlet{
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  HttpSession session = req.getSession(false);
	  if (session != null) {
		session.invalidate();
		req.setAttribute("msg", "Sucessfully LogedOut..!");
		req.getRequestDispatcher("./loginForm.jsp").forward(req, resp);
	}
}
}
