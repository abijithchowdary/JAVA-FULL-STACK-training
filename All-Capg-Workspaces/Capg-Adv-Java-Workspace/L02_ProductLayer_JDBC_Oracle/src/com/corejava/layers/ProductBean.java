package com.corejava.layers;

import java.io.Serializable;

public class ProductBean implements Serializable{
	
	private int sno;
	private String pname;
	private double price;
	
	ProductBean(){
		
	}
	ProductBean(int sno,String pname,double price){
		this.sno = sno;
		this.pname = pname;
		this.price = price;
	}
	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return "Sno: " + sno + " ProductName: " + pname + " Price: " + price;
	}
}
