package com.jtest;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String loginActionReturn = (String) request.getAttribute("FailedToLogin");
        
        out.print("<html><body>");
        out.print("<form action=\"process.jsp\" method=\"post\">");
        out.print("<br><br>");
        if(null != loginActionReturn) {
        	out.print("<center><h4 style=\"color:red;\">" + loginActionReturn + "</h4></center>");
        }    
        out.print("<center><table>");
        out.print("<tr><td><strong>User ID</strong></td><td><input type=\"text\" name=\"Name\" /></td></tr>");
        //out.print("<center><strong>User Name:</strong><input type=\"text\" name=\"Name\" /></center>");
        //out.print("<center><strong>User Password:</strong><input type=\"text\" name=\"Password\" /></center>");
        out.print("<tr><td><strong>Password</strong></td><td><input type=\"password\" name=\"Password\" /></td></tr>");
        out.print("<tr><td></td><td><input type=\"submit\" value=\"Login\" /></td></tr>");
        out.print("</table></center>");
        out.print("</form>");
        out.print("</body></html>");
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
