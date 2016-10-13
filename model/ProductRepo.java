package model;


import model.product.CD;
import model.product.Game;
import model.product.Movie;
import model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;


public class ProductRepo {
	private HashMap<String, Product> productH = new HashMap<>();
	
	public ProductRepo(ArrayList<String> productTitles, ArrayList<String> productIds, ArrayList<String> productTypes) {
		
	}
	
	public ProductRepo() {

	}

	public void addProduct(String title, String id, String type) {
		if (productH.get(id) == null) {
			switch (type)
			{
				case "M":
					addMovie(title, id);
					break;
				case "G":
					addGame(title, id);
					break;
				case "C":
					addCD(title, id);
					break;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void addMovie(String title, String id) {
		productH.put(id, new Movie(title, id));
	}

	public void addCD(String title, String id) {
		productH.put(id, new CD(title, id));

	}

	public void addGame(String title, String id) {
		productH.put(id, new Game(title, id));

	}

	public HashMap<String, Product> getProductsHashMap() {
		return productH;
	}
	
	public void setProductsHashMap(HashMap<String, Product> productList) {
		productH = productList;
	}
	
}
