package model.factory;

import model.product.CD;
import model.product.Game;
import model.product.Movie;
import model.product.Product;

public class ProductFactory {

	public static Product createProduct(String title, String id, String type) {
		Product product = null;
		switch (type) {
		case "Movie":
			product = new Movie(title, id);
			break;
		case "Game":
			product = new Game(title, id);
			break;
		case "CD":
			product = new CD(title, id);
			break;
		default:
			throw new NullPointerException();
		}
		return product;
	}

}
