package com.udemy.testdb;
import java.sql.*;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TesDbServlet
 */
@WebServlet(name = "TestDbServlet", urlPatterns = { "/TestDbServlet" })
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//setup connect variable
		String user = "hbstudent";
		String pass = "hbstudent";
				
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.cj.jdbc.Driver";
		//get connection to db
		
		try {
			
			System.out.println("Connecting to database:" + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Connection succcessful");
			
			myConn.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
			throw new ServletException(exc);
		}
		
		
	}

}
