package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServletHO
 */
@WebServlet("/register")
public class RegistrationServletHO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServletHO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String user=request.getParameter("user");
		String pass=request.getParameter("pass");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Connection con;
		String query="Insert into Login values(?,?);";
		try {
			con = DriverManager
			        .getConnection("jdbc:mysql://localhost:3306/virtusa",
			                "root", "Mourya@2022");
			PreparedStatement stmt = con.prepareStatement(query);
			Statement st=con.createStatement();
//			PreparedStatement check=con.prepareStatement("select * from Login where UserName=?;");
//			check.setString(1, user);
//			ResultSet rs1=check.executeQuery();
//			if(!rs1.next()) {
//				stmt.setString(1,user);
//				stmt.setString(2, pass);
//				int p=stmt.executeUpdate();
//				out.println(p+" rows added to databse");
//			}
//			else {
//				out.println("User already exists");
//			}
			stmt.setString(1,user);
			stmt.setString(2, pass);
			try {
			stmt.execute();
			out.println("1 row added to databse");
			}catch(Exception e) {
				out.println("User already exists");
			}
			
			ResultSet rs=st.executeQuery("select * from Login");
			out.println("Existing Users:");
			while(rs.next()) {
				out.println(rs.getString(1)+" "+rs.getString(2));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
}
			
	

}
