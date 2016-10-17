package controller;

import model.persistance.Persistable;
import model.product.Product;
import model.ProductRepo;
import model.client.Customer;
import model.persistance.ToFile;
import java.util.HashMap;

import javax.swing.JOptionPane;


public class ShopController {
	private final ProductRepo model = new ProductRepo();
	private Persistable persister;
	public ShopController() {
		
	}
	
	public double getPrice(int productidx, int days) {
		return 1.5*days;
	}

	public void addProduct(String title, String id, String type)
	{
		model.addProduct(title,id,type);
	}

	public HashMap<String, Product> getProductsHashMap(){
		return model.getProductsHashMap();
	}
	public HashMap<String, Customer> getCustomerHashMap() { return model.getCustomerHashMap();}
	public void reloadFromFile()
	{
		model.setProductsHashMap(new ToFile().loadProducts());
		model.setCustomerHashMap(new ToFile().loadCustomers());
	}

	public void saveToFile()
	{
		persister.save(this);
	}

	public void setPersitible(String option) {
		if(option.equals("Database")){
			JOptionPane.showMessageDialog(null, "This option isn't suppoted yet");
		}else{
			persister = new ToFile();
		}
		//TODO: remove if derbydb works
		persister = new ToFile();
	}
}
