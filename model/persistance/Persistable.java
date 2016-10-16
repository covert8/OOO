package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.product.Product;

import java.util.HashMap;

public interface Persistable {
	
	void init();
	void save(ShopController shopController);
	//TODO perhaps merge load functions
	HashMap<String, Product> loadProducts();
	HashMap<String,Customer> loadCustomers();

}
