package model;

import model.client.Customer;
import model.facade.ModelFacadeInterface;
import model.factory.ProductFactory;
import model.product.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductRepo implements ModelFacadeInterface {
	private HashMap<String, Product> productH = new HashMap<>();
	private HashMap<String, Customer> customerH = new HashMap<>();
	private ArrayList<String> mailinglist = new ArrayList<>();

	@Deprecated
	ProductRepo(ArrayList<String> productTitles, ArrayList<String> productIds, ArrayList<String> productTypes) {

	}

	public ProductRepo() {
		
	}

	public void addCustomer(Customer customer) {
		customerH.put(customer.getName(), customer);
	}

	public void addProduct(String title, String id, String type) {
		if (productH.get(id) == null) {
			sendMailNewProduct(title);
			switch (type) {
			case "Movie":
				productH.put(id, ProductFactory.createProduct(title, id, "Movie"));
				break;
			case "Game":
				productH.put(id, ProductFactory.createProduct(title, id, "Game"));
				break;
			case "CD":
				productH.put(id, ProductFactory.createProduct(title, id, "CD"));
				break;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void AddCustomer(String name,String email) {
		if (!customerH.containsKey(name)){
			customerH.put(name, new Customer(name, email));
		}
	}
	

	public HashMap<String, Product> getProductsHashMap() {
		return productH;
	}

	public void setProductsHashMap(HashMap<String, Product> productList) {
		productH = productList;
	}

	public HashMap<String, Customer> getCustomerHashMap() {
		return customerH;
	}

	public void setCustomerHashMap(HashMap<String, Customer> customerH) {
		this.customerH = customerH;
	}

	public ArrayList<String> getMailingList() {
		return mailinglist;
	}

	public void subscribeCustomer(String email) {
		mailinglist.add(email);
		
	}

	public void unSubscribeCustomer(String email) {
		mailinglist.remove(email);
	}


	public void sendMailNewProduct(String productName) {
		for (String mail : getMailingList()) {
			JOptionPane.showMessageDialog(null,"We have send an email to " + mail + "With the new product " + productName+".");
		}
	}
}
