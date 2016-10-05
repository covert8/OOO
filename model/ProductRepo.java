package model;

import java.util.ArrayList;
import java.util.HashMap;


public class ProductRepo {
	private ArrayList<Product> products = new ArrayList<>();
	private HashMap<String, Product> productH = new HashMap<>();
	
	public ProductRepo(ArrayList<String> productTitles, ArrayList<String> productIds, ArrayList<String> productTypes) {
		assert productIds.size() == productTitles.size() && productTitles.size() == productTypes.size();
		for (int i = 0; i < productIds.size(); i++) {
			products.add(new Product(productTitles.get(i), productIds.get(i), productTypes.get(i)));
		}
	}

	public ProductRepo() {

	}

	public void addProduct(String title, String id, String type) {
		if (productH.get(id) == null) {
			if (type.equals("M")) {
				Movie movie = new Movie(title, id, type);
				productH.put(id, movie);
			} else if (type.equals("G")) {
				Game game = new Game(title, id, type);
				productH.put(id, game);
			} else if (type.equals("C")){
				CD cd = new CD(title, id, type);
				productH.put(id, cd);
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void addProduct(String title, String id, String type, boolean beschikbaar) {
		productH.put(id, new Product(title, id, type));
	}

	public void addMovie(String title, String id, String type) {
		productH.put(id, new Movie(title, id, type));
	}

	public void addCD(String title, String id, String type) {
		productH.put(id, new CD(title, id, type));

	}

	public void addGame(String title, String id, String type) {
		productH.put(id, new Game(title, id, type));

	}

	public HashMap<String, Product> getProductsHashMap() {
		return productH;
	}
}
