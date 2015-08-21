package com.somitsolutions.training.java.restaurant;

public class Cashier extends Employee{
	
	public Cashier(){
		
	}
	
	public Cashier(int empId, String name){
		super(empId, name);
	}
	
	public void generateBill(int customerId){
		Customer customer = Restaurant.getRestaurant().getCustomer(customerId);
		Bill newBill = new Bill(customerId,customer);
		Restaurant.getRestaurant().addNewBill(newBill);
		System.out.println("Total Amount for Customer :" + customer.getCustomerName() + " is " + newBill.calculateTotal());
	}
	
	public void sayGoodBye(int customerId){
		Customer customerToBeRemoved = Restaurant.getRestaurant().getCustomer(customerId);
		Restaurant.getRestaurant().sayGoodBye(customerToBeRemoved);
	}
}
