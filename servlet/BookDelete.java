package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookBean;
import dao.BookDAO;

/**
 * Servlet implementation class BookDelete
 */
@WebServlet("/BookDelete")
public class BookDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(false);
		BookBean bb = new BookBean();
		
		bb.setBk_id(request.getParameter("bk_id"));
		
		if (BookDAO.deleteBook(request.getParameter("bk_id")) > 0) {
			session.setAttribute("msgid", "3");
			response.sendRedirect("bookinglist.jsp");
		} 
		else {
			session.setAttribute("msgid", "4");
			response.sendRedirect("bookinglist.jsp");
		}
	}
}
