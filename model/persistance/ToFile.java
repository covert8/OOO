package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.product.CD;
import model.product.Game;
import model.product.Movie;
import model.product.Product;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class ToFile implements Persistable {

	@Override
	public void save(ShopController shopController) {
		List<Dumpable> dumpableList = new ArrayList<>();
		dumpableList.addAll(shopController.getProductsHashMap().values());
		File f = new File("shop.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(fos);
			for (Dumpable dump : dumpableList) {
				pw.write(dump.dump());
				//pw.write(product.getProductId() + "," + product.getProductTitle() + "," + product.getProductType()
				//		+ "\n");
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
			String id = "", type = "", title = "";

			Scanner in = new Scanner(new FileReader("shop.txt"));
			Scanner line = null;

			while (in.hasNext()) {
				line = new Scanner(in.nextLine());
				line.useDelimiter(",");
				id = line.next();
				title = line.next();
				type = line.next();
				if (type.equals("CD")) {
					productList.put(id, new CD(title, id));
				} else if (type.equals("Movie")) {
					productList.put(id, new Movie(title, id));
				} else if (type.equals("Game")) {
					productList.put(id, new Game(title, id));
				}
			}
			in.close();
			assert line != null;
			line.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public HashMap<String, Customer> loadCustomers()
	{
		throw new NotImplementedException();
	}

	@Override
	public void init() {
		// Shouldn't do anything
	}

}
