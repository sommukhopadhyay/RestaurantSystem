package com.somitsolutions.training.java.restaurant;

public class Item {
	private int mItemId;
	private String mName;
	private float mPrice;
	
	public Item(){
		
	}
	
	public Item(int id, String name, float price){
		mItemId = id;
		mName = name;
		mPrice = price;
	}
	public int getItemId() {
		return mItemId;
	}
	public void setItemId(int mItemId) {
		this.mItemId = mItemId;
	}
	public String getItemName() {
		return mName;
	}
	public void setItemName(String mName) {
		this.mName = mName;
	}
	public float getItemPrice() {
		return mPrice;
	}
	public void setItemPrice(float mPrice) {
		this.mPrice = mPrice;
	}
}


