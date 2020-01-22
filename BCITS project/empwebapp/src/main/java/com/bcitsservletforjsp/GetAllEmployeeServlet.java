package com.bcitsservletforjsp;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/seeAllEmploye")
public class GetAllEmployeeServlet extends HttpServlet{
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from EmployeePrimaryInfo ");
		List<EmployeePrimaryInfo> employeeList= query.getResultList();
		req.setAttribute("empList", employeeList);
		manager.close();
		emf.close();
		req.getRequestDispatcher("/SeeAllEmployeee.jsp").forward(req, resp);
}
}
