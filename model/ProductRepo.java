package model;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;	
import java.io.UnsupportedEncodingException;
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
			if (type.equals("M")) {
				addMovie(title, id);
			} else if (type.equals("G")) {
				addGame(title, id);
			} else if (type.equals("C")){
				addCD(title, id);
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
