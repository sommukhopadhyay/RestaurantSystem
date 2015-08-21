package com.somitsolutions.training.java.restaurant;

import java.util.Observable;

public class Table extends Observable{
	
	private boolean mOccupied;
	
	public Table(){
		mOccupied = false;
	}
	
	public boolean isOccupied(){
		return 
				mOccupied == true;
	}
	
	public void bookTable(){
		mOccupied = true;
		
	}
	
	public void releaseTable(){
		mOccupied = false;
		setChanged();
		notifyObservers();
		
	}

}

