package com.somitsolutions.training.java.restaurant;

import java.util.Iterator;
import java.util.Scanner;

public class RestaurantSystem {
	public static void main(String[] args) {
		
		Scanner myScan = new Scanner(System.in);
		String s = "Y";
		Restaurant restaurant = Restaurant.getRestaurant();
		do{
			int tableId = 0;
			//int customerId = 0;
			Customer customer = null;
				System.out.println("Is there a new customer?");
				String ans = myScan.nextLine();
				if(ans.equalsIgnoreCase("Y")){
					customer = restaurant.getReceptionist().createNewCustomer();
					System.out.println(customer.getCustomerId());
					if(restaurant.getReceptionist().isAllTableOccupied() == false){
						restaurant.getReceptionist().bookATable();
						restaurant.getWaiter().displayMenu();
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
						restaurant.getReceptionist().displayOccupiedTable();
						System.out.println("Enter the Table number. Enter -9 if no one has finished...");
						tableId = Integer.parseInt(myScan.nextLine());
						
						if(tableId != -9 ){
		
							
							//System.out.println()
							restaurant.getWaiter().releaseTable(tableId);
							Customer customerJustServed = Restaurant.getRestaurant().getReceptionist().getLastCustomerServed();
							System.out.println(customerJustServed.getCustomerName());
							System.out.println(customerJustServed.getCustomerId());
							restaurant.getCashier().generateBill(customerJustServed);
							restaurant.getCashier().sayGoodBye(customerJustServed);
							
							
							restaurant.getWaiter().displayMenu();
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
								Customer current = restaurant.getReceptionist().getCurrentCustomer();
								System.out.println(current.getCustomerName());
								//System.out.println(current.getCustomerName());
								current.giveOrder(item, number_of_plates);
							}
						}
						/*
						restaurant.getWaiter().displayMenu();
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
							Customer current = restaurant.getReceptionist().getCurrentCustomer();
							//System.out.println(current.getCustomerName());
							current.giveOrder(item, number_of_plates);
						}*/
						else{
							continue;
						}
					}
				}
				else {
					if(restaurant.getReceptionist().isAnyTableOccupied() == true){
					//System.out.println("There are still some customers");
					System.out.println("Has anybody finished?");
					System.out.println("Enter the table number. Enter -9 if no one has finished...");
					System.out.println("Occupied tables are:");
					restaurant.getReceptionist().displayOccupiedTable();
					int numberTable = myScan.nextInt();
					myScan.nextLine();
					if(numberTable != -9){
						
						restaurant.getWaiter().releaseTable(numberTable);
						Customer customerJustServed = Restaurant.getRestaurant().getReceptionist().getLastCustomerServed();
						restaurant.getCashier().generateBill(customerJustServed);
						restaurant.getCashier().sayGoodBye(customerJustServed);
						
						if(restaurant.getReceptionist().isAllTableOccupied() == false){
							continue;
						}
						restaurant.getWaiter().displayMenu();
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
							Customer current = restaurant.getReceptionist().getCurrentCustomer();
							//System.out.println(current.getCustomerName());
							current.giveOrder(item, number_of_plates);
						}
						
						
						////////////////
						}
					else {
						continue;
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

