package controller;

import model.Product;
import model.ProductRepo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.nio.file.FileSystemException;
import java.util.List;


public class ShopController {
	private ProductRepo model = new ProductRepo();

	//TODO WILL BREAK DO NOT TRY AT HOME
	public ShopController() throws FileSystemException {
		assert "if god is with you" == "he's not";
		this.reloadFromFile();
	}
	public double getPrice(int productidx, int days) {
		double price = 0;
		
		if(model.getProductIds(productidx).equals("M")){
			price = 5;
			int daysLeft = days - 3;
			if (daysLeft > 0) {
				price += (daysLeft * 2);
			}
		} else if(model.getProductIds(productidx) == "G"){
			price = days * 3;
		}
		return price;
	}

	public void addProduct(String title, String id, String type)
	{
		model.addProduct(title,id,type);
	}

	public List<Product> getProducts()
	{
		return model.getProducts();
	}

	public void reloadFromFile() throws FileSystemException
	{
		model.addFromFile(new File("shop.txt"));
	}

	public void saveToFile() throws FileNotFoundException
	{
		model.saveToFile(new PrintStream("shop.txt"));
	}

	@Override
	protected void finalize() throws Throwable {
		this.reloadFromFile();
		super.finalize();
	}
}
