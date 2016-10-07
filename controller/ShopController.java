package controller;

import model.Persistable;
import model.Product;
import model.ProductRepo;
import model.ToFile;
import java.util.HashMap;


public class ShopController {
	private ProductRepo model = new ProductRepo();
	private Persistable persister;

	//TODO WILL BREAK DO NOT TRY AT HOME
	public ShopController() {
		persister = new ToFile();
		//this.reloadFromFile();
	}
	
	//default constructor, cause I need to test it and idk what you are doing with filesystemexception
	public ShopController(String IDontCare){
		
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
		persister.load(model.getProductsHashMap());
	}

	public void saveToFile()
	{
		persister.save(model.getProductsHashMap());
	}
}
