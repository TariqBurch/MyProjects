package model;

import java.io.Serializable;

public class Student implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String fName;
	private String lName;
	
	public Student(int id, String fName, String lName) {
		
		this.id = id;
		this.fName = fName;
		this.lName = lName;
	}
	public Student() {
		this(0,"","");
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lName=" + lName + "]";
	}
	
	
	
	
	

}
