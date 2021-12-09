package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StaffBean;
import dao.StaffDAO;

/**
 * Servlet implementation class StaffDelete
 */
@WebServlet("/StaffDelete")
public class StaffDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		
		StaffBean sb = new StaffBean();
		sb.setS_no(request.getParameter("s_no"));
		
		if (StaffDAO.staffDelete(request.getParameter("s_no")) > 0) {
			session.setAttribute("msgid", "3");
			response.sendRedirect("stafflist.jsp");
		} 
		else {
			session.setAttribute("msgid", "4");
			response.sendRedirect("stafflist.jsp");
		}
	} 
}
