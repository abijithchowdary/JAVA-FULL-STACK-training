package com.capg.Springboot;

public class ProductBean {
	private long pid;
	private String pname;
	private double price;
	public ProductBean(long pid,String pname,double price){
		this.pid = pid;
		this.pname = pname;
		this.price = price;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
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
}