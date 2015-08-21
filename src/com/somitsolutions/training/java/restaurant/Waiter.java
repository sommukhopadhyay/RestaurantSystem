package com.somitsolutions.training.java.restaurant;

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
			Restaurant.getRestaurant().releaseTable(tableId);
			
			
			//mTables.remove(tableId);
			//System.out.println("Table number" + tableId + "is available now...");
			
		}
		/*if(Restaurant.getRestaurant().getCustomerQueue().isEmpty() == false){
			Restaurant.getRestaurant().getReceptionist().bookATable();
		}*/
		
		if ((Restaurant.getRestaurant().getCustomerQueue().isEmpty() == false) ||  (Restaurant.getRestaurant().getReceptionist().isAnyTableOccupied() == true)){
			System.out.println("There are still some customers...");
		}
		
		if ((Restaurant.getRestaurant().getCustomerQueue().isEmpty() == true) && (Restaurant.getRestaurant().getReceptionist().isAnyTableOccupied() == false)){
			System.out.println("All served...");
			Restaurant.getRestaurant().getCustomerArray().clear();
		}
		
	}
	
	

}
