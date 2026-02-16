package com.capg.hibernate;
import java.io.Serializable;

public class Student {
	private int sid;
	private String sname;
	private String semail;
	private long smobile;
	
	Student(){
		this.sid = sid;
		this.sname = sname;
		this.semail = semail;
		this.smobile = smobile;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public long getSmobile() {
		return smobile;
	}

	public void setSmobile(long smobile) {
		this.smobile = smobile;
	}
	public String toString() {
		return "sid : "+sid+", sname : "+sname+", semail : "+semail+", smobile : "+smobile;
	}
}
