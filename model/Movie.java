package model;

public class Movie extends Product{
	Movie(String productTitles, String productTypes, String productIds) {
		super(productTitles, productTypes, productIds);
	}

	public double getPrice(int iDag)
	{
		return 1.5*iDag;
	}
}
