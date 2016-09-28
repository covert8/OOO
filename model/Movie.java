package model;

public class Movie extends Product implements Rentable{
	Movie(String productTitles, String productTypes, String productIds) {
		super(productTitles, productTypes, productIds);
	}
}
