package com.capg.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class StudentDaoImpl implements StudentDao{
	
	private DataSource dataSource;
	
	StudentDaoImpl(){
		
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void save(StudentBean bean) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		try { 
			
			connection = dataSource.getConnection(); 
			
			pstmt = connection.prepareStatement("INSERT INTO STUDENTBEAN VALUES(?,?,?,?)");
			
			pstmt.setString(1, bean.getName());
			pstmt.setInt(2, bean.getRegNo()); 
			pstmt.setString(3, bean.getBranch()); 
			pstmt.setString(4, bean.getEmail());
			
			pstmt.execute();
			
			System.out.println("Student Added Successfully!");
			
		} catch (Exception e) {
			
			System.out.println("Failed to insert the record!");
			e.printStackTrace();
		}
		
		finally {
			try {
				pstmt.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public StudentBean get(int regNo) {
		 
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		StudentBean res = null;
		
		try {
			
			con = dataSource.getConnection();
			
			stmt = con.createStatement();
	
			String query = "SELECT * FROM STUDENTBEAN WHERE REGNO=" + regNo;
			
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				res = new StudentBean();
				res.setName(rs.getString("NAME"));
				res.setRegNo(rs.getInt("REGNO"));
				res.setBranch(rs.getString("BRANCH"));
				res.setEmail(rs.getString("EMAIL"));;
			}
			
		} catch (Exception e) {
			
			System.out.println("Error While fetching the record!");
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return res;
	}

	@Override
	public int removeStudent(int regNo) {
		
		Connection con = null;
		Statement stmt = null;
		
		int res = 0;
		
		try {
			
			con = dataSource.getConnection();
			
			stmt = con.createStatement();
	
			String query = "DELETE FROM STUDENTBEAN WHERE REGNO=" + regNo;
			
			res = stmt.executeUpdate(query);
			
		} catch (Exception e) {
			
			System.out.println("Error While fetching the record!");
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	@Override
	public int updateStudentName(int regNo,String newname) {
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		int res = 0;
		
		try {
			
			con = dataSource.getConnection();
			
			stmt = con.prepareStatement("UPDATE STUDENTBEAN SET NAME = ? WHERE REGNO = ?");
			
			stmt.setString(1,newname);
			stmt.setInt(2,regNo);
			
			res = stmt.executeUpdate();
			
		} catch (Exception e) {
			
			System.out.println("Error While Updating the record!");
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
}
