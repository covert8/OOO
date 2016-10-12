package controller;

import model.Persistable;
import model.Product;
import model.ProductRepo;
import model.ToFile;
import java.util.HashMap;

import javax.swing.JOptionPane;


public class ShopController {
	private ProductRepo model = new ProductRepo();
	private Persistable persister;
	public ShopController() {
		
	}
	
	public double getPrice(int productidx, int days) {
		double price = 0;
		/*
		if(model.getProductIds(productidx).equals("M")){
			price = 5;
			int daysLeft = days - 3;
			if (daysLeft > 0) {
				price += (daysLeft * 2);
			}
		} else if(model.getProductIds(productidx) == "G"){
			price = days * 3;
		} else if (model.getProductIds(productidx) == "C"){
			price = days * 1.5;
		}
		return price;
		*/
		//TODO: move this to rentableCD/DjBD/...
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
		//model.setProductsHashMap(persister.load(model.getProductsHashMap()));
		model.setProductsHashMap(new ToFile().load());
		//System.out.println(model.getProductsHashMap().size());
	}

	public void saveToFile()
	{
		persister.save(model.getProductsHashMap());
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
