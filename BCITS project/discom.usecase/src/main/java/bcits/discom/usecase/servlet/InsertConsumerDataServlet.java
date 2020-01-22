package bcits.discom.usecase.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bcits.discom.usecase.bean.ConsumerInfoBean;
import bcits.discom.usecase.factory.DiscomDAO;

@WebServlet
public class InsertConsumerDataServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String fname = req.getParameter("fname");
	String lname = req.getParameter("lname");
	String email = req.getParameter("email");
	long pnumber = Long.parseLong(req.getParameter("pnumber"));
	String password = req.getParameter("psw");
	String rrNumber = req.getParameter("rrNumber");
	String region = req.getParameter("region");
	String consumerType = req.getParameter("consumeType");
	String houseNum = req.getParameter("houseNum");
	String inputAddress1 = req.getParameter("inputAddress1");
	String inputAddress2 = req.getParameter("inputAddress2");
	
	ConsumerInfoBean consumerSet1 = new ConsumerInfoBean();
	consumerSet1.setFirstName(fname);
	consumerSet1.setLastName(lname);
	consumerSet1.setEmail(email);
	consumerSet1.setPhoneNumber(pnumber);
	consumerSet1.setRrNumber(rrNumber);
	consumerSet1.setPassword(password);
	consumerSet1.setRegion(region);
	consumerSet1.setTypeOfConsumer(consumerType);
	consumerSet1.setHouseNumber(houseNum);
	consumerSet1.setAddress1(inputAddress1);
	consumerSet1.setAddress2(inputAddress2);
	
	DiscomDAO.insertAllDate(consumerSet1);
	
	
			
}
}
