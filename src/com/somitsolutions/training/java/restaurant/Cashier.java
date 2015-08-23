package com.somitsolutions.training.java.restaurant;

public class Cashier extends Employee{
	
	public Cashier(){
		
	}
	
	public Cashier(int empId, String name){
		super(empId, name);
	}
	
	public void generateBill(Customer customer){
		//Customer customer = Restaurant.getRestaurant().getCustomer(customer);
		//System.out.println(customer.getCustomerName());
		Bill newBill = new Bill(customer.getCustomerId(),customer);
		Restaurant.getRestaurant().addNewBill(newBill);
		System.out.println("Total Amount for Customer :" + customer.getCustomerName() + " is " + newBill.calculateTotal());
	}
	
	public void sayGoodBye(Customer customer){
		//Customer customerToBeRemoved = Restaurant.getRestaurant().getCustomer(customerId);
		Restaurant.getRestaurant().getReceptionist().sayGoodBye(customer);
	}
}
