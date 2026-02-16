package com.capg.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JdbcCrudSwitch {

    public static void main(String[] args) {
    	
    	
    	Connection con = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "scott";
        String password = "tiger";
        
        try {
        	
        	Class.forName(driver);

	        try {
	        	
	            con = DriverManager.getConnection(url, user, password);
	            Scanner sc = new Scanner(System.in);
	            
	            boolean flag = true;
	        
		        while(flag){
		
		            System.out.println("1. Add Row");
		            System.out.println("2. Update Row");
		            System.out.println("3. Retrieve Rows");
		            System.out.println("4. Delete Row");
		            System.out.println("5. Exit");
		            System.out.print("Enter your choice: ");
		
		            int choice = sc.nextInt();
		
		            switch (choice) {
		
		                case 1:
		                    String insertSql =
		                        "INSERT INTO Employeeinfo1 VALUES (?, ?, ?)";
		                    PreparedStatement psInsert = con.prepareStatement(insertSql);
		
		                    System.out.print("Enter ID: ");
		                    psInsert.setInt(1, sc.nextInt());
		
		                    System.out.print("Enter Name: ");
		                    psInsert.setString(2, sc.next());
		
		                    System.out.print("Enter Salary: ");
		                    psInsert.setDouble(3, sc.nextDouble());
		
		                    int insertCount = psInsert.executeUpdate();
		                    System.out.println(insertCount + " row inserted");
		                    break;
		
		                case 2:
		                    String updateSql =
		                        "UPDATE Employeeinfo1 SET SAL = ? WHERE EMPNO = ?";
		                    PreparedStatement psUpdate = con.prepareStatement(updateSql);
		
		                    System.out.print("Enter New Salary: ");
		                    psUpdate.setDouble(1, sc.nextDouble());
		
		                    System.out.print("Enter Employee ID: ");
		                    psUpdate.setInt(2, sc.nextInt());
		
		                    int updateCount = psUpdate.executeUpdate();
		                    System.out.println(updateCount + " row updated");
		                    break;
		
		                case 3:
		                    String selectSql = "SELECT * FROM Employeeinfo1";
		                    Statement stmt = con.createStatement();
		                    ResultSet rs = stmt.executeQuery(selectSql);
		
		                    while (rs.next()) {
		                        System.out.println(
		                            rs.getInt("EMPNO") + " " +
		                            rs.getString("ENAME") + " " +
		                            rs.getDouble("SAL")
		                        );
		                    }
		                    break;
	
		                case 4:
		                    String deleteSql =
		                        "DELETE FROM Employeeinfo1 WHERE EMPNO = ?";
		                    PreparedStatement psDelete = con.prepareStatement(deleteSql);
		
		                    System.out.print("Enter Employee ID: ");
		                    psDelete.setInt(1, sc.nextInt());
		
		                    int deleteCount = psDelete.executeUpdate();
		                    System.out.println(deleteCount + " row deleted");
		                    break;
		                   
		                case 5:
		                	System.out.println("Exiting...!");
		                	flag = false;
		                	break;
		                	
		                default:
		                    System.out.println("Invalid choice!");
		            }
		            
		        }
		        con.close();
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
        }
        catch(ClassNotFoundException e) {
        	System.out.println(e);
        }
        
    }
}