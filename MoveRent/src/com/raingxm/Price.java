package com.raingxm;

abstract class Price {
	abstract public int getPriceCode();
	abstract public double getCharge(int daysRented);
	
	public int getFrequentPoints(int daysRented) {
		return 1;
	}
}
