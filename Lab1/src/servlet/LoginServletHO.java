package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServletHO
 */
@WebServlet("/LoginServletHO")
public class LoginServletHO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletHO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		ServletContext ctx=getServletContext();
		ctx.setAttribute("admin", "Mourya");
		if(user.equals("admin") && pass.equals("techie")){
			RequestDispatcher rd= request.getRequestDispatcher("SuccessServletHO");
			request.setAttribute("userName", user);
			rd.forward(request, response);
		}
		else {
			
			RequestDispatcher rd= request.getRequestDispatcher("FailureServletHO");
			request.setAttribute("userName", user);
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
