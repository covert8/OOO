package model;

import model.client.Customer;
import model.facade.ModelFacadeInterface;
import model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by covert on 17/11/16.
 */
public class ModelFacade implements ModelFacadeInterface {
	ProductRepo productRepo = new ProductRepo();

	@Override
	public void addCustomer(Customer customer) {
		productRepo.addCustomer(customer);
	}

	@Override
	public void addProduct(String title, String id, String type) {
		productRepo.addProduct(title, id, type);
	}

	@Override
	public void AddCustomer(String name, String email) {
		productRepo.AddCustomer(name, email);
	}

	@Override
	//TODO questionable
	public HashMap<String, Product> getProductsHashMap() {
		return productRepo.getProductsHashMap();
	}

	@Override
	public void setProductsHashMap(HashMap<String, Product> productList) {
		productRepo.setProductsHashMap(productList);
	}

	@Override
	public HashMap<String, Customer> getCustomerHashMap() {
		return productRepo.getCustomerHashMap();
	}

	@Override
	public void setCustomerHashMap(HashMap<String, Customer> customerH) {
		productRepo.setCustomerHashMap(customerH);
	}

	@Override
	public ArrayList<String> getMailingList() {
		return productRepo.getMailingList();
	}

	@Override
	public void subscribeCustomer(String email) {
		productRepo.subscribeCustomer(email);
	}

	@Override
	public void unSubscribeCustomer(String email) {
		productRepo.subscribeCustomer(email);
	}
}
