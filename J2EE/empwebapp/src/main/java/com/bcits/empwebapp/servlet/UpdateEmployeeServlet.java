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

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Get the Form Data
		int empId = Integer.parseInt(req.getParameter("empId"));
		String empName = req.getParameter("empName");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = entityManager.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, empId);
		boolean isAdded = false;
		try {
			transaction.begin();
			info.setEmpname(empName);
			transaction.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		
		
		out.print("<html>");
		out.println("<body");
		if(isAdded) {
		// Display Employee Record
		out.println("<h1 style ='color: green'> Employee Id "+empId +" Updated..</h1> <br>");
		}else {
			// display empId not Found
			out.println("<h1 style ='color:red;'> Employee ID " + empId + " Not Found </h1>");
		}
		out.println("</body");
		out.print("</html>");

	}
}
