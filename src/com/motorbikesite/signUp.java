package com.motorbikesite;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public signUp() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		int age = Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String passWord = request.getParameter("passWord");
		//System.out.println(request.getParameter("first"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		DatabaseData data = new DatabaseData(first, last, age, email, passWord);
		DatabaseHandling myHandle = DatabaseHandling.getInstance(data);
		System.out.println(myHandle);
		myHandle.registerDriver();
		myHandle.openConnection();
		myHandle.executeInsert();
		
		
		out.print(first);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
