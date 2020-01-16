package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId = Integer.parseInt(req.getParameter("empId"));
		String empname = req.getParameter("empname");
		String designation = req.getParameter("designation");
		Date joiningDate =java.sql.Date.valueOf(req.getParameter("doj"));
		double salary = Double.parseDouble(req.getParameter("salary"));
		long mobileNum = Long.parseLong(req.getParameter("mobileNum"));
		String password = req.getParameter("password");
		
//		SimpleDateFormat dateFormat =new SimpleDateFormat();
//		Date joiningDate =null;
//		try {
//			joiningDate = dateFormat.parse(joiningDate);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		EmployeePrimaryInfo employeePrimaryInfo = new EmployeePrimaryInfo();
		employeePrimaryInfo.setEmpId(empId);
		employeePrimaryInfo.setEmpname(empname);
		employeePrimaryInfo.setDesignation(designation);
		employeePrimaryInfo.setDOJ(joiningDate);
		employeePrimaryInfo.setSal(salary);
		employeePrimaryInfo.setMobileNum(mobileNum);
		employeePrimaryInfo.setPassword(password);
		
		//Store Employee data  
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(employeePrimaryInfo);
			transaction.commit();
			isAdded = true;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		emf.close();
		
		PrintWriter out = resp.getWriter();
		out.println("<head>");
		out.println("<body>");

		if(isAdded) {
			out.println("<h1 style ='color :green';>Employee Id for "+empId +" Data is Inserted.. </h1>");
		}else {
			out.println("<h1 style ='color :red';>Unnable to add Employee Record </h1>");
		}
		out.println("</body>");
		out.println("</head>");
	}
}
