package com.raingxm;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	
	public Customer(String name) {
		this._name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.add(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		String result = "Rental Record for " + getName() + "\n";
		
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentPoints()) + " frequent renter points";
		return result;
	}
	
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentPoints() {
		int result = 0;
		Enumeration rentals = _rentals.elements();
		while(rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
			result += each.getFrequentPoints();
		}
		return result;
	}
}
