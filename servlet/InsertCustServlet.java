package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustBean;
import bean.StaffBean;
import dao.CustDAO;
import dao.StaffDAO;

/**
 * Servlet implementation class InsertCustServlet
 */
@WebServlet("/InsertCust")
public class InsertCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		CustBean cb = new CustBean();
		
		cb.setC_name(request.getParameter("c_name"));
		cb.setC_phone(request.getParameter("c_phone"));
		cb.setC_address(request.getParameter("c_address"));
		cb.setC_zipcode(request.getParameter("c_zipcode"));
		cb.setC_city(request.getParameter("c_city"));
		
		if (CustDAO.addCust(cb) > 0) {
			session.setAttribute("msgid", "5");
			response.sendRedirect("customer.jsp");
		} 
		else {
			session.setAttribute("msgid", "6");
			response.sendRedirect("customer.jsp");
		}
	}
}