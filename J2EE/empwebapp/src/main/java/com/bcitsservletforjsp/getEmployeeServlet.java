package com.bcitsservletforjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/getEmp")
public class getEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		PrintWriter out = resp.getWriter();
		if (session != null) {
		int empId = Integer.parseInt(req.getParameter("empId"));
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, empId);
		req.setAttribute("empInfo", info);
		manager.close();
		emf.close();
		req.getRequestDispatcher("./searchEmployee.jsp").forward(req, resp);
		}else {
			out.println("<h1 style ='color:red;'> Login First</h1>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./LoginForm.jsp");
			requestDispatcher.include(req, resp);
		}
	}
}
