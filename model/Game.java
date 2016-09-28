package model;

public class Game extends Product implements Rentable {
	Game(String productTitles, String productIds, String productTypes) {
		super(productTitles, productIds, productTypes);
	}
}
