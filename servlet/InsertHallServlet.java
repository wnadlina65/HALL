package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.HallBean;
import dao.HallDAO;
import dao.StaffDAO;

/**x
 * Servlet implementation class InsertHallServlet
 */
@WebServlet("/AddHall")
public class InsertHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		HallBean hb = new HallBean();
		
		hb.setH_name(request.getParameter("h_name"));
		hb.setH_status(request.getParameter("h_status"));
		hb.setH_price(request.getParameter("h_price"));
		hb.setHt_id(request.getParameter("ht_id"));
		
		if(HallDAO.addHall(hb) > 0) {
			session.setAttribute("msgid", "5");
			response.sendRedirect("hall.jsp");
		} 
		else {
			session.setAttribute("msgid", "6");
			response.sendRedirect("hall.jsp");
		}
		 //redirect to list hall page
		/*request.setAttribute("hallList", HallDAO.getAll());
		RequestDispatcher rd = request.getRequestDispatcher("hall.jsp");
		rd.forward(request, response);*/
		System.out.println("masuk doPost");
    	System.out.println(request.getParameter("h_id"));
    	response.getWriter().append("Served at :").append(request.getContextPath());
	}
}
