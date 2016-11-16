package model.product;

public class Movie extends Product {
	public Movie(String productTitles, String productIds) {
		super(productTitles, productIds);
	}

	@Override
	public String getProductType() {
		return "Movie";
	}
}
