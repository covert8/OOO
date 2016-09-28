package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepo {
	private ArrayList<Product> products = new ArrayList<>();

	public ProductRepo(ArrayList<String> productTitles, ArrayList<String> productIds, ArrayList<String> productTypes) {
		assert productIds.size() == productTitles.size() && productTitles.size() == productTypes.size();
		for (int i = 0; i<productIds.size();i++)
		{
			products.add(new Product(productTitles.get(i),productIds.get(i),productTypes.get(i)));
		}
	}

	public ProductRepo()
	{

	}

	public String getProductTitles(int i)
	{
		return products.get(i).getProductTitles();
	}

	public String getProductTypes(int i)
	{
		return products.get(i).getProductTypes();
	}

	public String getProductIds(int i)
	{
		return products.get(i).getProductId();
	}

	public void addProduct(String title, String id, String type) {
		products.add(new Product(title,id,type));
	}
	public void addMovie(String title, String id, String type)
	{
		products.add(new Movie(title,id,type));
	}

	public void addCD(String title, String id, String type)
	{
		products.add(new CD(title,id,type));
	}

	public void addGame(String title, String id, String type)
	{
		products.add(new Game(title,id,type));
	}
	public List<Product> getProducts()
	{
		return products;
	}

}
