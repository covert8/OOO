package model.persistance;

import java.util.HashMap;

import controller.ShopController;
import model.client.Customer;
import model.product.Product;

public interface Persistable {
	
	void init();
	void save(ShopController shopController);
	//TODO perhaps merge load functions
	HashMap<String, Product> loadProducts();
	HashMap<String,Customer> loadCustomers();

}
