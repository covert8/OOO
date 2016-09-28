package model;

public class CD extends Product implements Rentable
{
	CD(String productTitles, String productIds, String productTypes) {
		super(productTitles, productIds, productTypes);
	}
}
