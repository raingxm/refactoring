package com.raingxm;

public class Movie {
	
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	public static final int CHILDRENS = 2;
	
	private String _title;
	private Price _price;
	
	public Movie(String title, int priceCode) {
		this._title = title;
		setPriceCode(priceCode);
	}
	
	public void setPriceCode(int arg) {
		switch (arg) {
			case REGULAR:
				this._price = new RegularPrice();
				break;
			case NEW_RELEASE:
				this._price = new NewReleasePrice();
				break;
			case CHILDRENS:
				this._price = new ChildrensPrice();
				break;
			default:
				throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public void setTitle(String _title) {
		this._title = _title;
	}
	
	public String getTitle() {
		return this._title;
	}
	
	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
	public int getFrequentPoints(int daysRented) {
		return _price.getFrequentPoints(daysRented);
	}
}
