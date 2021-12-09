package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.HallBean;
import bean.StaffBean;
import dao.HallDAO;
import dao.StaffDAO;

/**
 * Servlet implementation class UpdateHall
 */
@WebServlet("/UpdateHall")
public class UpdateHall extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { 
		
		try {
			if(request.getParameter("save") != null) {
				response.setContentType("text/html");
				HttpSession session = request.getSession(false);
				
				HallBean hb = new HallBean();
				
				hb.setH_name(request.getParameter("h_name"));
				hb.setH_status(request.getParameter("h_status"));
				hb.setH_price(request.getParameter("h_price"));
				hb.setHt_id(request.getParameter("ht_id"));
				hb.setH_id(request.getParameter("h_id"));
				
				if (HallDAO.hallUpdate(hb) == true) {
					session.setAttribute("msgid", "1");
					response.sendRedirect("hall.jsp");
				} else {
					session.setAttribute("msgid", "2");
					response.sendRedirect("hall.jsp");
				} // error page
			}
		}
		catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
