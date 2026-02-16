package com.corejava.layers;

import java.util.List;

public class ProductService {
	
	ProductDao dao = new ProductDao();
	
	public List<ProductBean> displayProducts() throws Exception {
		
		return dao.displayProducts();
	}
	
	public int addProduct(int sno,String pname,double price) throws Exception {
		
		ProductBean pb = new ProductBean();
		
		pb.setSno(sno);
		pb.setPname(pname);
		pb.setPrice(price);
		
		return dao.addProduct(pb);
	}
	
	public int deleteProduct(int sno) throws Exception {
		return dao.deleteProduct(sno);
	}
}
