package servlet;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StaffBean;
import dao.StaffDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/index")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, java.io.IOException {
    	
    	try {
    		StaffBean user = new StaffBean();
    		user.setS_no(request.getParameter("s_no"));
    		user.setS_pass(request.getParameter("s_pass"));
    		user = StaffDAO.login(user);
    		if(user.isValid()) {
    			HttpSession session = request.getSession(true);
    			session.setAttribute("firstName", user.getS_FName());
    			session.setAttribute("s_id", user.getS_id());
    			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    			rd.forward(request, response);
    		}
    		else response.sendRedirect("invalidlogin.jsp"); //error page
    	}
    	catch(Throwable theException) 
    	{
    		System.out.println(theException);
    	}
    }
    
}