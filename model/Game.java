package model;

public class Game extends Product implements Rentable {
	Game(String productTitles, String productTypes, String productIds) {
		super(productTitles, productTypes, productIds);
	}
}
