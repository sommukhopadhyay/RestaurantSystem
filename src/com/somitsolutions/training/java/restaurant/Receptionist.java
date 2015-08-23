package com.somitsolutions.training.java.restaurant;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class Receptionist extends Employee implements Observer{
	
	Scanner myScan = new Scanner(System.in);
	private Customer currentCustomer;
	private Customer lastCustomerServed;
	
	public Receptionist(){
		currentCustomer = null;
	}

	public Receptionist(int empId, String name){
		super(empId, name);
		currentCustomer = null;
	}
	
	public boolean isAnyTableOccupied(){
		for(int i = 0; i < Restaurant.getRestaurant().MAX_NUMBER_OF_TABLES; i++){
			if (Restaurant.getRestaurant().getTables().get(i).isOccupied() == true){
				return true;
			}	
		}
		return false;
	}
	
	public int findTheEmptyTable(){
		
		for(int i = 0; i < Restaurant.getRestaurant().MAX_NUMBER_OF_TABLES; i++){
			if(Restaurant.getRestaurant().getTables().get(i).isOccupied() == false){
				return i;
			}
		}
		return -1;
	}
	
	public void displayOccupiedTable(){
		for (int i = 0; i <Restaurant.getRestaurant().MAX_NUMBER_OF_TABLES; i++){
			if(Restaurant.getRestaurant().getTables().get(i).isOccupied() == true){
				System.out.println("Table No. " + i + " is occupied");
			}
		}
	}
	
	public boolean isAllTableOccupied(){
		int val = findTheEmptyTable();
		if (val == -1){
			return true;
		}
		else {
			return false;
		}
	}
	
	public void bookATable(){
		if(isAllTableOccupied() == false){
			int tableNumber = findTheEmptyTable();
			
			//get the customer from the list in the FIFO order
			//and remove him from the queue
			if(!Restaurant.getRestaurant().getCustomerQueue().isEmpty()){
				
				/*Iterator it = Restaurant.getRestaurant().getCustomerArray().iterator();
				while(it.hasNext()){
					Customer c = (Customer) it.next();
					if(tableNumber == c.getAllocatedTableId()){
						lastCustomerServed = c;
					}
				}*/
				currentCustomer = Restaurant.getRestaurant().getCustomerQueue().pollLast();
				
				//set the customer id same as table id, because a customer is identified
				//by the table which he occupies
				//currentCustomer.setCustomerName(mCustomerName);
				currentCustomer.setAllocatedTableId(tableNumber);
				//currentCustomer.getOrder().setOrderId(currentCustomer.getCustomerId());
				Restaurant.getRestaurant().addCustomerToTheServingArray(currentCustomer);
				Restaurant.getRestaurant().bookTable(tableNumber);
				System.out.println(currentCustomer.getCustomerName() + " has been given table number: "+ tableNumber);
			}	
		}
		//return null;
	}
	
	public void addNewCustomer(Customer customer){
		//Customer newCustomer =  new Customer();
		Restaurant.getRestaurant().getCustomerQueue().offerFirst(customer);
		//currentCustomer = Restaurant.getRestaurant().getCustomerQueue().pollLast();
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//System.out.println(Restaurant.getRestaurant().getCustomerQueue().pollLast().getCustomerName());
		if(!Restaurant.getRestaurant().getCustomerQueue().isEmpty()){
			bookATable();
		}
		
	}

	public Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public void setCurrentCustomer(Customer currentCustomer) {
		this.currentCustomer = currentCustomer;
	}
	
	public Customer createNewCustomer(){
		Customer customer = new Customer();
		//System.out.println(customer.getCustomerId());
		System.out.println("Please enter customer name...");
		String customerName = myScan.nextLine();
		customer.setCustomerName(customerName);
		
		addNewCustomer(customer);
		
		return customer;
	}
	
	public void sayGoodBye(Customer customer){
		Restaurant.getRestaurant().getCustomerArray().remove(customer);
		Restaurant.getRestaurant().getCustomerServed().add(customer);
	}

	public Customer getLastCustomerServed() {
		return lastCustomerServed;
	}

	public void setLastCustomerServed(Customer lastCustomerServed) {
		this.lastCustomerServed = lastCustomerServed;
	}
}
