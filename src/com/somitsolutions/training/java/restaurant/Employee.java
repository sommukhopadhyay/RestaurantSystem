package com.somitsolutions.training.java.restaurant;



public class Employee {
	protected int empId;
	protected String name;
	
	public Employee(){
			
	}

	public Employee (int id, String name){
		this.empId = id;
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
