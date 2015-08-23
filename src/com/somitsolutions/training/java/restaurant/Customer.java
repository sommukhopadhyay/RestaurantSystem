package com.somitsolutions.training.java.restaurant;

import java.util.Random;

public class Customer{
	private int mCustomerId; 
	private Order mOrder;					
	private String mCustomerName;
	private int allocatedTableId;
	
	

	public Customer(){
		Random r = new Random();
		mCustomerId = r.nextInt(10000); // A random number between 0 & 10000
		mOrder = new Order(mCustomerId);
		//addObserver(Restaurant.getRestaurant());
	}
	
	/*public Customer(int customerId){
		//mCustomerId = customerId;
		mOrder = new Order(customerId);
	}*/
	
	public int getCustomerId() {
		return mCustomerId;
	}

	/*public void setCustomerId(int mCustomerId) {
		this.mCustomerId = mCustomerId;
	}*/
	
	public void giveOrder(Item item, int numberOfPlates){
		//Order newOrder = new Order(mCustomerId);
		ItemOrder newItemOrder = new ItemOrder(item,  numberOfPlates);
		mOrder.addOrder(newItemOrder);
	}
	
	public void iAmDone(){
															
	}

	public Order getOrder() {
		return mOrder;
	}

	public void setOrder(Order mOrder) {
		this.mOrder = mOrder;
	}

	public String getCustomerName() {
		return mCustomerName;
	}

	public void setCustomerName(String mCustomerName) {
		this.mCustomerName = mCustomerName;
	}
	
	public Customer findCustomer(int id ){
		
		if(id == mCustomerId){
			return this;
		}
		return null;
	}

	public int getAllocatedTableId() {
		return allocatedTableId;
	}

	public void setAllocatedTableId(int allocatedTableId) {
		this.allocatedTableId = allocatedTableId;
	}
}

