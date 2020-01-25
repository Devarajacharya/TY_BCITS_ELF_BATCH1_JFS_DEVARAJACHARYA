package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the Form Data
		int empId = Integer.parseInt(req.getParameter("empId"));

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);

		if (session != null) {

			EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("emsPersistenceUnit");
			EntityManager manager = entityManager.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, empId);
			boolean isAdded = false;
			EmployeePrimaryInfo loggedInEmpInfo = (EmployeePrimaryInfo) session.getAttribute("empInfo");

			try {
				transaction.begin();
				manager.remove(info);
				transaction.commit();
				isAdded = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			manager.close();

			if (isAdded) {
				// Display Employee Record
				out.println("<h1 style ='color: green'> Hello " + loggedInEmpInfo.getEmpname() + " </h1> <br>");
				out.print("<a href='employeeHome.html' > Home </a>");
				out.println("<h1 style ='color: green'> Employee record Is Deleted </h1> <br>");
			} else {
				out.println("<h1 style ='color:red;'> Employee ID " + empId + " Not Found </h1>");
			}

		} else {
			out.println("<h1 style ='color:red;'> Login First</h1>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./LoginForm.html");
			requestDispatcher.include(req, resp);
		}

	}
}