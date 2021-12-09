package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookBean;
import dao.BookDAO;
import dao.StaffDAO;

/**
 * Servlet implementation class InsertBookServlet
 */
@WebServlet("/AddBooking")
public class InsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		BookBean b = new BookBean();
		
		b.setBk_name(request.getParameter("bk_name"));
		b.setBk_strdate(request.getParameter("bk_strdate"));
		b.setBk_enddate(request.getParameter("bk_enddate"));
		b.setBk_pax(request.getParameter("bk_pax"));
		b.setBk_totprice(request.getParameter("bk_totprice"));
		b.setC_id(request.getParameter("c_id"));
		b.setH_id(request.getParameter("h_id"));
		
		if(BookDAO.addBook(b) > 0) {
			session.setAttribute("msgid", "5");
			response.sendRedirect("bookinglist.jsp");
		} 
		else {
			session.setAttribute("msgid", "6");
			response.sendRedirect("bookinglist.jsp");
		}
	}

}
