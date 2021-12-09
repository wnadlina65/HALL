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
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
			response.setContentType("text/html");
					
			HttpSession session = request.getSession(false);
			BookBean bb = new BookBean();
			
			bb.setBk_strdate(request.getParameter("bk_strdate"));
			bb.setBk_enddate(request.getParameter("bk_enddate"));
			bb.setBk_pax(request.getParameter("bk_pax"));
			bb.setBk_totprice(request.getParameter("bk_totprice"));
			bb.setC_id(request.getParameter("c_id"));
			bb.setH_id(request.getParameter("h_id"));
			bb.setBk_id(request.getParameter("bk_id"));
			
			if (BookDAO.updateBook(bb) == true) {
				session.setAttribute("msgid", "1");
				response.sendRedirect("bookinglist.jsp");
			} 
			else {
				session.setAttribute("msgid", "2");
				response.sendRedirect("bookinglist.jsp");
			}
		}
		catch (Throwable theException) {
			System.out.println(theException);
		}
	} 
}
