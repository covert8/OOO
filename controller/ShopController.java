package controller;

import model.persistance.Persistable;
import model.product.Product;
import model.ProductRepo;
import model.persistance.ToFile;
import java.util.HashMap;

import javax.swing.JOptionPane;


public class ShopController {
	private ProductRepo model = new ProductRepo();
	private Persistable persister;
	public ShopController() {
		
	}
	
	public double getPrice(int productidx, int days) {
		//TODO refactor
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
		//model.setProductsHashMap(persister.loadProducts(model.getProductsHashMap()));
		model.setProductsHashMap(new ToFile().loadProducts());
		model.setCustomerHashMap(new ToFile().loadCustomers());
		//System.out.println(model.getProductsHashMap().size());
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
