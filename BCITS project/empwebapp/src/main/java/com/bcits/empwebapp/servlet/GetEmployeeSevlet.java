package com.bcits.empwebapp.servlet;

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

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/getEmployee")
public class GetEmployeeSevlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		// session validates
		HttpSession session = req.getSession(false);

		if (session != null) {
			// Get the Form Data
			int empId = Integer.parseInt(req.getParameter("empId"));

			EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
			EntityManager manager = emf.createEntityManager();
			EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, empId);
			// Display Employee Record
			if (info != null) {
				EmployeePrimaryInfo loggedInEmpInfo = (EmployeePrimaryInfo) session.getAttribute("empInfo");
				out.print("<html>");
				out.println("<body");
				out.println("<h2 style ='color: green'> Hello " + loggedInEmpInfo.getEmpname()  + "</h2> <br>");

				out.print("<a href='employeeHome.html' > Home </a>");
				out.println("<h2 style ='color: green'> Employee ID " + empId + " Is Found </h2> <br>");
				out.println("Name             : " + info.getEmpname());
				out.println("<br>Date Of Birth: " + info.getDOB());
				out.println("<br>Designation  : " + info.getDesignation());
				out.println("<br>Salary       : " + info.getSal());
				out.println("<br>Mobile no    : " + info.getMobileNum());
				out.println("</body");
				out.print("</html>");
			} else {
				// display empId not Found
				out.print("<html>");
				out.println("<body");
				out.println("<h1 style ='color:red;'> Employee ID " + empId + " Not Found </h1>");
				out.println("</body");
				out.print("</html>");
			}
			manager.close();
			emf.close();
		} else {

			out.println("<h1 style ='color:red;'> Login First</h1>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./LoginForm.html");
			requestDispatcher.include(req, resp);
		}

	}
}
