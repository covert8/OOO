package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.product.Product;

import java.util.HashMap;

public interface Persistable {
	
	public void init();
	public void save(ShopController shopController);
	//TODO perhaps merge load functions
	public HashMap<String, Product> loadProducts();
	public HashMap<String,Customer> loadCustomers();

}
