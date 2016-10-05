package view;

import java.io.FileNotFoundException;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.xml.bind.SchemaOutputResolver;

import controller.ShopController;
import model.Product;

/**
 * Created by louis on 21/09/2016.
 */
public class ShopView {

	private static ShopController controller = new ShopController("a");

	public double getPrice(int productidx, int days) {
		return controller.getPrice(productidx, days);
	}

	public static void rentProduct() {
		// TODO: impl: rental product
	}

	public static void listProcducts() {
		String output = "";
		for (Product product : controller.getProductsHashMap().values()) {
			output += product.getProductId() + ": " + product.getProductTitle() + "\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}

	public static void saveProducts() {
		try {
			controller.saveToFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static void uploadProducts() {
		// TODO impl uploadProduct
	}

	public static void loanProduct() {
		// TODO impl loanProduct.
	}

	public static void collectProduct() {
		// TODO collectProduct
	}

	public void addProduct() {
		String title = JOptionPane.showInputDialog("Enter the title:");
		if (title.isEmpty()) {
			throw new IllegalArgumentException("Invalid Title");
		} else if (Character.isLowerCase(title.charAt(0))) {
			throw new IllegalArgumentException("First character has to be uppercase");
		}
		String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/ C for CD):");
		if (type.isEmpty() || !(type.equals("M") || type.equals("G") || type.equals("C"))) {
			throw new IllegalArgumentException("Invalid Type");
		}
		Random rand = new Random();
		boolean added = false;
		while (!added) {
			try {
				int id = rand.nextInt(90000) + 10000;
				controller.addProduct(title, "" + id, type);
				added = true;
				JOptionPane.showMessageDialog(null, "The random generated ID is " + id);
			} catch (IllegalArgumentException e) {
			}
		}
	}

	public void showProduct() {
		String idAsString = askProductId();
		if (controller.getProductsHashMap().get(idAsString) != null) {
			JOptionPane.showMessageDialog(null,
					controller.getProductsHashMap().get(idAsString).getProductId() + ": "
							+ controller.getProductsHashMap().get(idAsString).getProductTitle() + " - "
							+ controller.getProductsHashMap().get(idAsString).getProductType());
		} else {
			JOptionPane.showMessageDialog(null, "Product not found, are you sure you did enter the right product id?");
		}
	}

	public void showPrice() {
		String id = askProductId();

		if (controller.getProductsHashMap().get(id) != null) {
			String daysString = JOptionPane.showInputDialog("Give the amount of days");
			int days;
			try {
				days = Integer.parseInt(daysString);
				if (days < 0) {
					throw new IllegalArgumentException("Give a positive number");
				}
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException("Give a number");
			}
			JOptionPane.showMessageDialog(null, controller.getPrice(Integer.parseInt(id), days));
		} // end if found
		else {
			JOptionPane.showMessageDialog(null, "Not found");
		}
	}

	public void showError(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}

	public void getProductStatus() {
		String id = askProductId();
		if (controller.getProductsHashMap().get(id) != null) {
			String status = controller.getProductsHashMap().get(id).isBeschikbaar() ? "Available" : "Unavaileble";
			JOptionPane.showMessageDialog(null, "The product status of "
					+ controller.getProductsHashMap().get(id).getProductTitle() + " is " + status);
		}
	}

	public String askProductId() {
		String idAsString = JOptionPane.showInputDialog("Enter the id:");
		int id;
		try {
			id = Integer.parseInt(idAsString);
			if (id < 0) {
				throw new IllegalArgumentException("Give a positive number");
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Give a number");

		}
		return id + "";
	}
}
