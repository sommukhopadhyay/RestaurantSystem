package com.somitsolutions.training.java.restaurant;

import java.util.Scanner;

public class RestaurantSystem {
	public static void main(String[] args) {
		
		Scanner myScan = new Scanner(System.in);
		String s = "Y";
		Restaurant restaurant = Restaurant.getRestaurant();
		do{
			int tableId = 0;
			int customerId = 0;
			Customer customer = null;
				System.out.println("Is there a new customer?");
				String ans = myScan.nextLine();
				if(ans.equalsIgnoreCase("Y")){
					customer = new Customer();
					System.out.println("Please enter customer name...");
					String customerName = myScan.nextLine();
					customer.setCustomerName(customerName);
					restaurant.addNewCustomer(customer);
					if(restaurant.isAllTableOccupied() == false){
						restaurant.bookATable();
						restaurant.getMenu().display();
						System.out.println("Choose Menu from the above List");
						System.out.println("How many items do you want to order?");
						int number_of_items = myScan.nextInt();
						for (int i = 0; i<number_of_items; i++){
							System.out.println("Choose from the numbers at the leftmost position");
							int item_position = myScan.nextInt();
							System.out.println("How many plates of menu item " + item_position + " you want to order");
							int number_of_plates = myScan.nextInt();
							if(i == number_of_items - 1){
								myScan.nextLine();
							}
							
							Item item = restaurant.getMenu().getMenu().get(item_position);
							customer.giveOrder(item, number_of_plates);
						}
					}
					else {
						System.out.println("Sorry all tables are occupied... Please wait...");
						System.out.println("Has anybody finished?");
						System.out.println("Occupied tables are:");
						Restaurant.getRestaurant().displayOccupiedTable();
						System.out.println("Enter -9 if noone has finished...");
						tableId = Integer.parseInt(myScan.nextLine());
						//customerId = Integer.parseInt(myScan.nextLine());
						//Customer customerDone = restaurant.getCustomer(customerId);
						//customerDone.iAmDone();
						if(tableId != -9 ){
							restaurant.generateBill(tableId);
							restaurant.releaseTable(tableId);
						}
						
					}
				}
				else {
					if(restaurant.isAnyTableOccupied() == true){
					//System.out.println("There are still some customers");
					System.out.println("Has anybody finished?");
					System.out.println("Enter -9 if noone has finished...");
					System.out.println("Occupied tables are:");
					Restaurant.getRestaurant().displayOccupiedTable();
					int numberTable = myScan.nextInt();
					myScan.nextLine();
					if(numberTable != -9){
						restaurant.generateBill(numberTable);
						restaurant.releaseTable(numberTable);
					}
					
					}
				}
			System.out.println("Do you want to continue?");
			s = myScan.nextLine();
			
			if(s.equalsIgnoreCase("N")){
				System.exit(0);
			}
			
		}while (s.equalsIgnoreCase("Y"));	
	}
}

