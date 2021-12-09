package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.CustBean;
import dao.CustDAO;

/**
 * Servlet implementation class CustDelete
 */
@WebServlet("/CustDelete")
public class CustDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//(request.getParameter("deleteCust").equals("Delete")) {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		
		CustBean cb = new CustBean();
		cb.setC_id(request.getParameter("c_id"));
		
		session.setAttribute("txt", "99");
		if(CustDAO.custDelete(request.getParameter("c_id")) > 0) {
			session.setAttribute("msgid", "3");
			response.sendRedirect("customer.jsp");
		} 
		else {
			session.setAttribute("msgid", "4");
			response.sendRedirect("customer.jsp");
		} // error page
		
	}
}
