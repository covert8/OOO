package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductRepo {
	private ArrayList<Product> products = new ArrayList<>();

	public ProductRepo(ArrayList<String> productTitles, ArrayList<String> productTypes, ArrayList<String> productIds) {
		assert productIds.size() == productTitles.size() && productTitles.size() == productTypes.size();
		for (int i = 0; i<productIds.size();i++)
		{
			products.add(new Product(productTitles.get(i),productTypes.get(i),productIds.get(i)));
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
		return products.get(i).getProductIds();
	}

	public void addProduct(String title, String type, String id) {
		products.add(new Product(title,type,id));
	}

	public List<Product> getProducts()
	{
		ArrayList<Product> temp = new ArrayList<>();
		Collections.copy(products,temp);
		return temp;
	}
}
