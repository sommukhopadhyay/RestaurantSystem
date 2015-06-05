package com.somitsolutions.training.java.restaurant;

public class Customer{
	private int mCustomerId; //this is same as Table id. Each customer is identified
	private Order mOrder;						//by the table they occupied
	private String mCustomerName;
	

	public Customer(){
		mCustomerId = 0;
		mOrder = new Order(mCustomerId);
		//addObserver(Restaurant.getRestaurant());
	}
	
	public Customer(int customerId){
		mCustomerId = customerId;
		mOrder = new Order(customerId);
	}
	public int getCustomerId() {
		return mCustomerId;
	}

	public void setCustomerId(int mCustomerId) {
		this.mCustomerId = mCustomerId;
	}
	
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
}

