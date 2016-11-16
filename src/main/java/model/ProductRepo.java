package model;

import java.util.ArrayList;
import java.util.HashMap;

import model.client.Customer;
import model.product.CD;
import model.product.Game;
import model.product.Movie;
import model.product.Product;

public class ProductRepo {
	private HashMap<String, Product> productH = new HashMap<>();
	private HashMap<String, Customer> customerH = new HashMap<>();
	private ArrayList<String> mailinglist = new ArrayList<>();

	@Deprecated
	public ProductRepo(ArrayList<String> productTitles, ArrayList<String> productIds, ArrayList<String> productTypes) {

	}

	public ProductRepo() {
		
	}

	public void addCustomer(Customer customer) {
		customerH.put(customer.getName(), customer);
	}

	// TODO enum misschien
	public void addProduct(String title, String id, String type) {
		if (productH.get(id) == null) {
			switch (type) {
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

	public void AddCustomer(String name,String email) {
		if (!customerH.containsKey(name)){
			customerH.put(name, new Customer(name, email));
		}
	}
	

	public HashMap<String, Product> getProductsHashMap() {
		return productH;
	}

	public HashMap<String, Customer> getCustomerHashMap() {
		return customerH;
	}
	public ArrayList<String> getMailingList(){
		return mailinglist;
	}
	public void setProductsHashMap(HashMap<String, Product> productList) {
		productH = productList;
	}

	public void setCustomerHashMap(HashMap<String, Customer> customerH) {
		this.customerH = customerH;
	}

	public void subscribeCustomer(String email) {
		mailinglist.add(email);
		
	}

	public void unSubscribeCustomer(String email) {
		mailinglist.remove(email);
	}

}
