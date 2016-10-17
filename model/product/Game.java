package model.product;

public class Game extends Product {
	public Game(String productTitles, String productIds) {
		super(productTitles, productIds);
	}

	@Override
	public String getProductType() {
		return "Game";
	}
}
