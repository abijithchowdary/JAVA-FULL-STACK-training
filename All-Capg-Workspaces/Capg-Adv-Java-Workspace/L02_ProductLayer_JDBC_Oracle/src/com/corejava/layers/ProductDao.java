package com.corejava.layers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	
	ConnectionDB cdb = new ConnectionDB();
	
	public List<ProductBean> displayProducts() throws Exception {
		
		List<ProductBean> list = new ArrayList<>();
		
		try(Connection conn = cdb.provideConnection();
		
		Statement st = conn.createStatement()){
		
		ResultSet rs = st.executeQuery("select * from product");
		
		while(rs.next()) {
			
			int sno = rs.getInt("sno");
			String pname = rs.getString("pname");
			double price = rs.getDouble("price");
			
			list.add(new ProductBean(sno,pname,price));
		}
		
		return list;
		
		}
	}
	
	public int addProduct(ProductBean pb) throws Exception {
		
		try(Connection conn = cdb.provideConnection();
		
		PreparedStatement ps = conn.prepareStatement("insert into product values(?,?,?)")){
		
		ps.setInt(1,pb.getSno());
		ps.setString(2, pb.getPname());
		ps.setDouble(3, pb.getPrice());
		
		return ps.executeUpdate();
		
		}
	}
	
	public int deleteProduct(int sno) throws Exception {
		
		try(Connection conn = cdb.provideConnection();
		
		PreparedStatement st = conn.prepareStatement("delete from product where sno = ?")){
		
		st.setInt(1,sno);
		
		return st.executeUpdate();
		
		}
		
	}
}
