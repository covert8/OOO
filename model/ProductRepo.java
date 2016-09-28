package model;

import sun.text.resources.iw.FormatData_iw_IL;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
	public void addMovie(String title, String type, String id)
	{
		products.add(new Movie(title,type,id));
	}

	public void addCD(String title, String type, String id)
	{
		products.add(new CD(title,type,id));
	}

	public void addGame(String title, String type, String id)
	{
		products.add(new Game(title,type,id));
	}
	public List<Product> getProducts()
	{
		return products;
	}

	public void saveToFile(PrintStream printStream)
	{
		assert printStream.checkError();
		products.parallelStream().forEach(product ->  printStream.print(product.toString()));
		printStream.flush();
		printStream.close();
	}

	public void addFromFile(File file)
	{
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if(line == "New Product")
				{
					assert ((line = br.readLine()) != null);
					String productTitles = line;
					String productTypes = br.readLine();
					String productIds = br.readLine();
					this.addProduct(productTitles,productTypes,productIds);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
