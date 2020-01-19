
package com.bcits.empwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/retrieveEmployee")
public class RetrieveEmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//Get the Form Data
	HttpSession session = req.getSession(false);	
	PrintWriter out = resp.getWriter();
	if(session != null) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
	EntityManager manager = emf.createEntityManager();
	Query query = manager.createQuery(" from EmployeePrimaryInfo ");
	List<EmployeePrimaryInfo> info = query.getResultList();
	resp.setContentType("text/html");
	
	if (info != null) {
		for (EmployeePrimaryInfo employeePrimaryInfo : info) {
		//Display Employee Record
		out.print("<html>");
		out.println("<body");
		out.println("Employee ID      : "+employeePrimaryInfo.getEmpId());
		out.println("<br>Name             : "+employeePrimaryInfo.getEmpname());
		out.println("<br>Date Of Birth: "+employeePrimaryInfo.getDOB());
		out.println("<br>Designation  : "+employeePrimaryInfo.getDesignation());
		out.println("<br>Salary       : "+employeePrimaryInfo.getSal());
		out.println("<br>Mobile no    : "+employeePrimaryInfo.getMobileNum()+"<br><br>");
		out.println("</body");
		out.println("</html>");
		}
	}else {
		//display empId not Found
		out.println("<h1 style ='color:red;'>No Employee Record id Found. </h1>");
	}
	manager.clear();
	emf.close();
	
	} else {
		out.println("<h1 style ='color:red;'> Login First</h1>");
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("./LoginForm.html");
		requestDispatcher.include(req, resp);
	}
	}
}


