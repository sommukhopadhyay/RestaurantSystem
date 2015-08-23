package com.somitsolutions.training.java.restaurant;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;




public class Restaurant {
	public static final int MAX_NUMBER_OF_TABLES = 2;
	private List<Table> mTables;
	//whenever a new customer comes we add him to the front of this queue
	private Deque<Customer> mCustomerQueue;
	private List<Customer> customerServed;
	private Menu mMenu;
	private List<Bill> billStore;
	private static Restaurant mResturantObject = null; 
	//private Customer currentCustomer;
	private List<Customer> customerArray;
	Employee cashier;
	Employee receptionist;
	Employee waiter;
	
	private Restaurant(){
		receptionist = new Receptionist(1, "Rita");
		waiter = new Waiter(10, "Shyam");
		cashier = new Cashier(100, "Ram");
		
		mTables = new ArrayList<Table>();
		mMenu = new Menu();
		billStore = new ArrayList<Bill>();
		mCustomerQueue = new ArrayDeque<Customer>(5);
		customerArray = new ArrayList<Customer>();
		setCustomerServed(new ArrayList<Customer>());
		//currentCustomer = null;
		for(int i = 0; i < MAX_NUMBER_OF_TABLES; i++){
			Table t = new Table();
			t.addObserver((Observer) receptionist);
			mTables.add(t);
		}
	}
	
	public List<Table> getTables(){
		return mTables;
	}
	
	public Deque<Customer> getCustomerQueue() {
		return mCustomerQueue;
	}

	public void setCustomerQueue(Deque<Customer> customerQueue) {
		this.mCustomerQueue = customerQueue;
	}

	public Menu getMenu() {
		return mMenu;
	}

	public void setMenu(Menu mMenu) {
		this.mMenu = mMenu;
	}
	
	//Singleton Pattern
	public static Restaurant getRestaurant(){
		if(mResturantObject == null)
			mResturantObject = new Restaurant();
		return mResturantObject;
	}
	
	public Customer getCustomer(int customerId){
		Iterator it = (Iterator) customerArray.iterator();
		
		while(it.hasNext()){
			Customer c = (Customer) it.next();
			if(customerId == c.getCustomerId()){
				return c;
			}
		}
		return null;
	}
	
	
	public List<Bill> getBillStore(){
		return billStore;
	}

	public Cashier getCashier(){
		return (Cashier)cashier;
	}
	
	public List<Customer> getCustomerArray(){
		return customerArray;
	}
	
	public Receptionist getReceptionist(){
		return (Receptionist)receptionist;
	}
	
	public Waiter getWaiter(){
		return (Waiter)waiter;
	}
	
	public void addCustomerToTheServingArray(Customer customer){
		customerArray.add(customer);
	}
	public void bookTable(int tableNumber){
		mTables.get(tableNumber).bookTable();
	}
	
	public void releaseTable(int tableNumber){
		mTables.get(tableNumber).releaseTable();
	}
	
	public void addNewBill(Bill bill){
		billStore.add(bill);
	}

	public List<Customer> getCustomerServed() {
		return customerServed;
	}

	public void setCustomerServed(List<Customer> customerServed) {
		this.customerServed = customerServed;
	}
	
	public void sayGoodBye(Customer customer){
		customerArray.remove(customer);	
	}
}


