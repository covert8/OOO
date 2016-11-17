package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.factory.ProductFactory;
import model.product.Product;

import java.io.*;
import java.util.*;

public class ToFile implements Persistable {

	@Override
	public void save(ShopController shopController) {
		List<Dumpable> dumpableList = new ArrayList<>();
		dumpableList.addAll(shopController.getProductsHashMap().values());
		dumpableList.addAll(shopController.getCustomerHashMap().values());
		File f = new File("shop.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(fos);
			for (Dumpable dump : dumpableList) {
				pw.write(dump.dump());
				// pw.write(product.getProductId() + "," +
				// product.getProductTitle() + "," + product.getProductType()
				// + "\n");
			}
			pw.flush();
			fos.close();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String, Product> loadProducts() {
		HashMap<String, Product> productList = new HashMap<>();
		try {
			String id, type, title;

			Scanner in = new Scanner(new FileReader("shop.txt"));
			Scanner line = null;

			while (in.hasNext()) {
				line = new Scanner(in.nextLine());
				line.useDelimiter(",");
				id = line.next();
				title = line.next();
				// TODO: breaks the program.
				type = line.next();
				switch (type) {
				case "CD":
					productList.put(id, ProductFactory.createProduct(title, id, "CD"));
					break;
				case "Movie":
					productList.put(id, ProductFactory.createProduct(title, id, "Movie"));
					break;
				case "Game":
					productList.put(id, ProductFactory.createProduct(title, id, "Game"));
					break;
				}
			}
			in.close();
			assert line != null;
			line.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}
		return productList;
	}

	@Override
	public HashMap<String, Customer> loadCustomers() {
		HashMap<String, Customer> customerList = new HashMap<>();
		try {
			String name, type, email;

			Scanner in = new Scanner(new FileReader("shop.txt"));
			Scanner line = null;

			while (in.hasNext()) {
				line = new Scanner(in.nextLine());
				line.useDelimiter(",");
				name = line.next();
				email = line.next();
				type = line.next();
				if (Objects.equals(type, "customer")) {
					customerList.put(name, new Customer(name, email));
				}
			}
			in.close();
			assert line != null;
			line.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
		}
		return customerList;
	}

	@Override
	public void init() {
		// Shouldn't do anything
	}

}
