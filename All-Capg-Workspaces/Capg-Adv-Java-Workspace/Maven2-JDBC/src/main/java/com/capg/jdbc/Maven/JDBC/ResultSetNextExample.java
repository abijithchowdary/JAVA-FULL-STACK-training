package com.capg.jdbc.Maven.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetNextExample {

	public static void main(String[] args) {
		
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "scott";
		String password = "tiger";
		
		try {
			
			Class.forName(driver);
			
			try {
				
				conn = DriverManager.getConnection(url,user,password);
				
				Statement st = conn.createStatement();
				
				ResultSet rs = st.executeQuery("select * from employeeinfo1");
				
				while(rs.next()) {
					
					System.out.println("Employee ID: " + rs.getInt(1));
					System.out.println("Employee Name: " + rs.getString("empname"));
					System.out.println("Employee Sal: " + rs.getInt(3));
					
				}
				
				conn.close();
			}
			catch(SQLException e) {
				
				System.out.println(e);
			}
		}
		catch(ClassNotFoundException e) {
			
			System.out.println(e);
		}
		
	}

}