package com.motorbikesite;
import java.sql.*;


public class DatabaseHandling {
	  private static DatabaseHandling instance = null;
	  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	  final String DB_URL = "jdbc:mysql://127.0.0.1";
	  final String USER = "root";
	  final String PASS = "root";
	  Connection conn = null;
	  Statement stmt = null;
	  private static DatabaseData data;
	  
	  private DatabaseHandling(){
	  }
	  
	  public static DatabaseHandling getInstance(DatabaseData passData) {
	      if(instance == null) {
	         instance = new DatabaseHandling();
	      }
	      data = passData;
	      return instance;
	   }
	  public void registerDriver(){
		      //STEP 2: Register JDBC driver
		      try {
				Class.forName(JDBC_DRIVER);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	  public void openConnection(){
		  System.out.println("Connecting to database...");
	      try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  public void executeInsert(){
		  System.out.println("Creating database...");
	      try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO motorbikesite.members (`first`, `last`, `age`, `email`, `passWord`) VALUES ('" + data.getFirst() + "', '" +data.getLast() +"', '"+ data.getAge() + "', '" + data.getEmail() +"', '" + data.getPassword() + "');";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      
	      //stmt.executeQuery(sql);
	     
	  }
	  public String executeQuery(){
		  String first = "";
		  System.out.println("inside EQ");
		  try {
			   System.out.println("inside try");
				stmt = conn.createStatement();
				String sql = "SELECT first FROM motorbikesite.members WHERE email='" + data.getEmail() + "' AND password='" + data.getPassword() + "'";
				 ResultSet rs = stmt.executeQuery(sql);
				 while (rs.next()) {
					 first = rs.getString("first");
					 System.out.println("inside results");
				 }
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  return first;
		  
		  
	  }
}
