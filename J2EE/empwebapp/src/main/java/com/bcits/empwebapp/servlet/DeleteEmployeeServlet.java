package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the Form Data
		int empId = Integer.parseInt(req.getParameter("empId"));

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		EntityManagerFactory entityManager = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			entityManager = Persistence.createEntityManagerFactory("emsPersistenceUnit");
			manager = entityManager.createEntityManager();
			transaction = manager.getTransaction();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, empId);
			transaction.begin();
			manager.remove(info);
			transaction.commit();

			// Display Employee Record
			out.print("<html>");
			out.println("<body");
			out.println("<h1 style ='color: green'> Employee record Is Deleted </h1> <br>");
			out.println("</body");
			out.print("</html>");

		} catch (Exception e) {
			// display empId not Found
			out.print("<html>");
			out.println("<body");
			out.println("<h1 style ='color:red;'> Employee ID " + empId + " Not Found </h1>");
			out.println("</body");
			out.print("</html>");
			transaction.rollback();
		} finally {
			manager.close();
		}

	}
}
