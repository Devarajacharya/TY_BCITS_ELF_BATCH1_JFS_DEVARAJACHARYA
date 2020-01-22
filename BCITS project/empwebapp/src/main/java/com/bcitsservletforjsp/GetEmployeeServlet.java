package com.bcitsservletforjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/getEmp")
public class GetEmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int empId = Integer.parseInt(req.getParameter("empId"));

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, empId);
		
		//send data to jsp
		req.setAttribute("empInfo", info);
		manager.close();
		emf.close();
		req.getRequestDispatcher("./searchEmployee.jsp").forward(req, resp);

	}
}
