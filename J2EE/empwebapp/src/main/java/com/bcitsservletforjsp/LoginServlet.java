package com.bcitsservletforjsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/login2")
public class LoginServlet  extends HttpServlet{
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
		
		if(employeePrimaryInfo != null) {
			//valid credentials
			//Create a session
			HttpSession session =req.getSession(true);
			session.setAttribute("empInfo", employeePrimaryInfo);
			req.getRequestDispatcher("./homePage.jsp").forward(req, resp);
		}else {
			//Invalid credential
			req.setAttribute("msg", "Invalid Employee ID / Password ..!");
			req.getRequestDispatcher("./loginForm.jsp").forward(req, resp);
		}
	}
	
	
}
