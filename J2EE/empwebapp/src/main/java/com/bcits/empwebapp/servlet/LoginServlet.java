package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empIdVal =Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		
		String jpql =" from EmployeePrimaryInfo where empId= :eId and password = :psw ";
		Query query = manager.createQuery(jpql);
		query.setParameter("eId", empIdVal);
		query.setParameter("psw", password);
		
		EmployeePrimaryInfo employeePrimaryInfo = null;
		try {
			employeePrimaryInfo=(EmployeePrimaryInfo) query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		PrintWriter out =resp.getWriter();
		if(employeePrimaryInfo != null) {
			//valid credentials
			//Create a session
			HttpSession session =req.getSession(true);
			session.setMaxInactiveInterval(60*5); //it will logout at certain time Eg.1minutes 
			session.setAttribute("empInfo", employeePrimaryInfo);
			
			out.println("<h1 style='color:green;'>Welcome "+employeePrimaryInfo.getEmpname()+" </h1>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./employeeHome.html");
			requestDispatcher.include(req, resp);
		}else {
			//invalid credentials
			out.println("<h1 style='color:red;'>Invalid Cradential..!!! </h1>");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("./LoginForm.html");
			requestDispatcher.include(req, resp);
		}
		emf.close();
		manager.close();
	}

}
