package com.somitsolutions.training.java.restaurant;

import java.util.Iterator;

public class Waiter extends Employee {

	public Waiter(){
		
	}
	
	public Waiter(int empId, String name){
		
		super(empId, name);
	}

	
	public void displayMenu(){
		Restaurant.getRestaurant().getMenu().display();
	}
	
	public void releaseTable(int tableId){
		if(Restaurant.getRestaurant().getTables().get(tableId).isOccupied() == true){
			Iterator it = Restaurant.getRestaurant().getCustomerArray().iterator();
			while(it.hasNext()){
				Customer c = (Customer) it.next();
				if(tableId == c.getAllocatedTableId()){
					Restaurant.getRestaurant().getReceptionist().setLastCustomerServed(c);
				}
			}
			Restaurant.getRestaurant().releaseTable(tableId);
		}
		
		
		if ((Restaurant.getRestaurant().getCustomerQueue().isEmpty() == false) ||  (Restaurant.getRestaurant().getReceptionist().isAnyTableOccupied() == true)){
			System.out.println("There are still some customers...");
			/**/
		}
		
		if ((Restaurant.getRestaurant().getCustomerQueue().isEmpty() == true) && (Restaurant.getRestaurant().getReceptionist().isAnyTableOccupied() == false)){
			System.out.println("All served...");
			Restaurant.getRestaurant().getCustomerArray().clear();
		}
		
	}
	
	

}
