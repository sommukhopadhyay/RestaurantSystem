package com.somitsolutions.training.java.restaurant;

import java.util.Iterator;


public class Bill {
	//private Order mOrder;
	private int mBillId;//this is the same as orderId
	private Customer mCustomer;
	public Bill(int Id, Customer customer){
		mBillId = Id;
		mCustomer = customer;
		
	}
	/*public Order getOrder() {
		return mOrder;
	}
	public void setOrder(Order mOrder) {
		this.mOrder = mOrder;
	}*/
	
	public float calculateTotal(){
		
		float retValue = 0;
		Iterator<ItemOrder> it = mCustomer.getOrder().getItemOrder().iterator();
		
		while (it.hasNext() == true){
			ItemOrder element = it.next();
			retValue+= (element.getItem().getItemPrice())* (element.getNumberOfPlates());
		}
		return retValue;
	}
	public int getBillId() {
		return mBillId;
	}
	public void setBillId(int mBillId) {
		this.mBillId = mBillId;
	}

}