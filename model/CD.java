package model;

public class CD extends Product implements Rentable
{
	CD(String productTitles, String productTypes, String productIds) {
		super(productTitles, productTypes, productIds);
	}
}
