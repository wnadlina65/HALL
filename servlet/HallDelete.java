package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.HallBean;
import dao.HallDAO;

/**
 * Servlet implementation class HallDelete
 */
@WebServlet("/HallDelete")
public class HallDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		
		HallBean hb = new HallBean();
		hb.setH_id(request.getParameter("h_id"));
		
		if (HallDAO.hallDelete(request.getParameter("h_id")) > 0) {
			
			session.setAttribute("msgid", "3");
			response.sendRedirect("hall.jsp");
		} 
		else {
			session.setAttribute("msgid", "4");
			response.sendRedirect("hall.jsp");
		}// error page
	}
}
