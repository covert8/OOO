package model.facade;

import model.client.Customer;
import model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by covert on 17/11/16.
 */
public interface ModelFacadeInterface {
	void addCustomer(Customer customer);

	void addProduct(String title, String id, String type);

	void AddCustomer(String name, String email);


	HashMap<String, Product> getProductsHashMap();

	void setProductsHashMap(HashMap<String, Product> productList);

	HashMap<String, Customer> getCustomerHashMap();

	void setCustomerHashMap(HashMap<String, Customer> customerH);

	ArrayList<String> getMailingList();

	void subscribeCustomer(String email);

	void unSubscribeCustomer(String email);
}
