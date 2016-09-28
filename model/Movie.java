package model;

public class Movie extends Product implements Rentable{
	Movie(String productTitles, String productIds, String productTypes) {
		super(productTitles, productIds, productTypes);
	}

}
