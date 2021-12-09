package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
			 //get the current session
			HttpSession session = request.getSession(true);
			 //set current session to null
			session.setAttribute("s_no", null);
			//destroy session
			 session.invalidate();
			 //redirect to login page
			response.sendRedirect("login.jsp");
		}
		catch (Throwable ex) {
			System.out.println(ex);
		} 
	}

}
