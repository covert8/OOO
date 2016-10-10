package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;	
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
	private ArrayList<Product> products = new ArrayList<>();
	private HashMap<String, Product> productH = new HashMap<>();

	public ProductRepo(ArrayList<String> productTitles, ArrayList<String> productIds, ArrayList<String> productTypes) {
		assert productIds.size() == productTitles.size() && productTitles.size() == productTypes.size();
		for (int i = 0; i < productIds.size(); i++) {
			products.add(new Product(productTitles.get(i), productIds.get(i), productTypes.get(i)));
		}
	}

	public ProductRepo() {

	}

	public String getProductTitles(int i) {
		return productH.get(i).getProductTitle();
	}

	public String getProductTypes(int i) {
		return productH.get(i).getProductType();
	}

	public String getProductIds(int i) {
		return productH.get(i).getProductId();
	}

	public void addProduct(String title, String id, String type) {
		// products.add(new Product(title,id,type));
		if (productH.get(id) == null) {
			if (type.equals("M")) {
				Movie movie = new Movie(title, id, type);
				productH.put(id, movie);
			} else if (type.equals("G")) {
				Game game = new Game(title, id, type);
				productH.put(id, game);
			} else if (type.equals("C")){
				CD cd = new CD(title, id, type);
				productH.put(id, cd);
			}
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void addProduct(String title, String id, String type, boolean beschikbaar) {
		// products.add(new Product(title,id,type,beschikbaar));
		productH.put(id, new Product(title, id, type));
	}

	public void addMovie(String title, String id, String type) {
		// products.add(new Movie(title,id,type));
		productH.put(id, new Movie(title, id, type));
	}

	public void addCD(String title, String id, String type) {
		// products.add(new CD(title,id,type));
		productH.put(id, new CD(title, id, type));

	}

	public void addGame(String title, String id, String type) {
		// products.add(new Game(title,id,type));
		productH.put(id, new Game(title, id, type));

	}

	public List<Product> getProducts() {
		return products;
	}

	public HashMap<String, Product> getProductsHashMap() {
		return productH;
	}

	public void saveToFile()
	{
		File f = new File("shop.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(fos);
			for (Product product : getProductsHashMap().values()) {
				pw.write(product.getProductId() + ";" + product.getProductTitle() + ";" + product.getProductType()
						+ ";");
			pw.flush();
			fos.close();
			pw.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addFromFile(File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (Objects.equals(line, "New Product")) {
					assert ((line = br.readLine()) != null);
					String productTitles = line;
					String productTypes = br.readLine();
					String productIds = br.readLine();
					boolean beschikbaar = Boolean.parseBoolean(br.readLine());
					this.addProduct(productTitles, productTypes, productIds, beschikbaar);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
