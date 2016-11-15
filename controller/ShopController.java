package controller;

import model.persistance.Persistable;
import model.persistance.ToDatabase;
import model.product.Product;
import model.ProductRepo;
import model.client.Customer;
import model.persistance.ToFile;

import java.awt.Dialog.ModalExclusionType;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopController {
	private final ProductRepo model = new ProductRepo();
	private Persistable persister;
	public HashMap<String, Customer> getCustomerHashMap() { 
		return model.getCustomerHashMap();
	}
	public ArrayList<String> getMailingList(){
		return model.getMailingList();
	}
	public ShopController() {
		
	}
	
	public double getPrice(int productidx, int days) {
		double fine = getFine(days);
		return fine + 1.5*days;
	}
	public double getFine(int days){
		if(days >=5){
			return 5*3;
		}
		return 0;
	}
	
	public void addProduct(String title, String id, String type)
	{
		model.addProduct(title,id,type);
	}

	public HashMap<String, Product> getProductsHashMap(){
		return model.getProductsHashMap();
	}
	public void reloadFromFile()
	{
		model.setProductsHashMap(persister.loadProducts());
		model.setCustomerHashMap(persister.loadCustomers());
	}

	public void saveToFile()
	{
		persister.save(this);
	}

	public void setPersitible(String option) {
		if(option.equals("Database")){
			persister = new ToDatabase();
		}else{
			persister = new ToFile();
		}
	}

	public void loadProducts()
	{
		persister.loadProducts();
	}

	public void loadCustomers()
	{
		persister.loadCustomers();
	}
	public void addCustumor(String name, String email){
		model.AddCustomer(name,email);
	}

	public void subscribeCustomer(String email) { 
		model.subscribeCustomer(email);
	}
	public void unSubscribeCustomer(String email) { 
		model.unSubscribeCustomer(email);
	}
}
