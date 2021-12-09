package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StaffBean;
import dao.StaffDAO;

@WebServlet("/StaffUpdate")
public class StaffServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			if(request.getParameter("save") != null) {
				response.setContentType("text/html");
				HttpSession session = request.getSession(false);
				
				StaffBean sb = new StaffBean();
				
				sb.setS_FName(request.getParameter("s_FName"));
				sb.setS_LName(request.getParameter("s_LName"));
				sb.setSt_id(request.getParameter("st_id"));
				sb.setS_no(request.getParameter("s_no"));
				
				if (StaffDAO.updateStaff(sb) == true) {
					session.setAttribute("msgid", "1");
					response.sendRedirect("stafflist.jsp");
				}
				else {
					session.setAttribute("msgid", "2");
					response.sendRedirect("stafflist.jsp");
				} // error page
			}
		} 
		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
