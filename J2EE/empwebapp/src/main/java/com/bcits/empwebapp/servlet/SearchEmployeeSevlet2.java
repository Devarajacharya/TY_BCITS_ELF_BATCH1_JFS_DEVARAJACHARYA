package com.bcits.empwebapp.servlet;

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

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/findEmployee")
public class SearchEmployeeSevlet2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//Get the Form Data
	int empId = Integer.parseInt(req.getParameter("empId"));
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
	EntityManager manager = emf.createEntityManager();
	EmployeePrimaryInfo info = manager.find(EmployeePrimaryInfo.class, empId);
	
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	if (info != null) {
		//Display Employee Record
		out.print("<html>");
		out.println("<body");
		out.println("<h1 style ='color: green'> Employee ID "+empId +" Is Found </h1> <br>");
		out.println("Name         : "+info.getEmpname());
		out.println("<br>Date Of Birth: "+info.getDOB());
		out.println("<br>Designation  : "+info.getDesignation());
		out.println("<br>Salary       : "+info.getSal());
		out.println("<br>Mobile no    : "+info.getMobileNum());
		out.println("</body");
		out.print("</html>");
	}else {
		//display empId not Found
		out.print("<html>");
		out.println("<body");
		out.println("<h1 style ='color:red;'> Employee ID "+empId+" Not Found </h1>");
		out.println("</body");
		out.print("</html>");
	}
	manager.clear();
	emf.close();
		
	}
}
