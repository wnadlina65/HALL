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
 * Servlet implementation class InsertStaff
 */
@WebServlet("/InsertStaff")
public class InsertStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		StaffBean sb = new StaffBean();
		
		sb.setS_FName(request.getParameter("s_FName"));
		sb.setS_LName(request.getParameter("s_LName"));
		sb.setS_no(request.getParameter("s_no"));
		sb.setS_pass(request.getParameter("s_pass"));
		sb.setSt_id(request.getParameter("st_id"));
		//sb.setS_id(Integer.parseInt(request.getParameter("s_id")));
		
		if(StaffDAO.addStaff(sb) > 0) {
			session.setAttribute("msgid", "5");
			response.sendRedirect("stafflist.jsp");
		} 
		else {
			session.setAttribute("msgid", "6");
			response.sendRedirect("stafflist.jsp");
		}
		System.out.println("masuk doPost");
    	System.out.println(request.getParameter("s_id"));
    	response.getWriter().append("Served at :").append(request.getContextPath());
	}

}
