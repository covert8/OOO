package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class ToFile implements Persistable {

	@Override
	public void save(HashMap<String, Product> productList) {
		File f = new File("shop.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(f);
			PrintWriter pw = new PrintWriter(fos);
			for (Product product : productList.values()) {
				pw.write(product.getProductId() + "," + product.getProductTitle() + "," + product.getProductType()
						+ "\n");
			}
			pw.flush();
			fos.close();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public HashMap<String, Product> load() {
		HashMap<String, Product> productList = new HashMap<String, Product>();
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
			line.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public void init() {
		// Shouldn't do anything
	}

}
