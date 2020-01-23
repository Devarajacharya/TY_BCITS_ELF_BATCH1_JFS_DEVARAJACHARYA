package bcits.discom.usecase.servlet;

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

import bcits.discom.usecase.bean.ConsumerInfoBean;
import bcits.discom.usecase.implementationclass.DiscomSignUpClass;

@WebServlet("/consumerSignUp")
public class InsertConsumerDataServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		long pnumber = Long.parseLong(req.getParameter("pnumber"));
		String password = req.getParameter("psw");
		String rrNumber = req.getParameter("rrNumber");
		String region = req.getParameter("region");
		String consumerType = req.getParameter("consumerType");
		String houseNum = req.getParameter("houseNum");
		String inputAddress1 = req.getParameter("inputAddress1");
		String inputAddress2 = req.getParameter("inputAddress2");

		ConsumerInfoBean consumer = new ConsumerInfoBean();
		consumer.setFirstName(fname);
		consumer.setLastName(lname);
		consumer.setEmail(email);
		consumer.setPhoneNumber(pnumber);
		consumer.setRrNumber(rrNumber);
		consumer.setPassword(password);
		consumer.setRegion(region);
		consumer.setTypeOfConsumer(consumerType);
		consumer.setHouseNumber(houseNum);
		consumer.setAddress1(inputAddress1);
		consumer.setAddress2(inputAddress2);

		PrintWriter out = resp.getWriter();
		if (DiscomSignUpClass.insertConsumerData(consumer)) {
			out.print("Record saved");
		} else {
			out.print("Record already present");
		}
	
	}
}
