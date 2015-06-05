package com.somitsolutions.training.java.restaurant;

public class ItemOrder {
	private Item mItem;
	private int mNumberOfPlates;
	
	
	public ItemOrder(){
		mItem = null;
		mNumberOfPlates = 0;
	}
	public ItemOrder(Item item, int numberOfPlates){
		mItem = item;
		mNumberOfPlates = numberOfPlates;
	}
	
	public Item getItem() {
		return mItem;
	}
	public void setItem(Item mItem) {
		this.mItem = mItem;
	}
	public int getNumberOfPlates() {
		return mNumberOfPlates;
	}
	public void setNumberOfPlates(int mNumberOfPlates) {
		this.mNumberOfPlates = mNumberOfPlates;
	}
}

