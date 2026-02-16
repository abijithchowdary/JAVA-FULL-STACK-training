package com.corejava.layers;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	public Connection provideConnection() throws Exception{
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		String username = "scott";
		
		String password = "tiger";
		
		Class.forName(driver);
		
		return DriverManager.getConnection(url,username,password);
		
	}
}
