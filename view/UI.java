package view;

import java.util.Random;

import javax.swing.JOptionPane;

import controller.ShopController;
import model.product.Product;

public class UI {

	private static ShopController controller;

	public static ShopController getController() {
		return controller;
	}

	public static void setController(ShopController controller) {
		UI.controller = controller;
	}

	public UI(ShopController controller) {
		setController(controller);
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
				getController().addProduct(title, "" + id, type);
				added = true;
				JOptionPane.showMessageDialog(null, "The random generated ID is " + id);
			} catch (IllegalArgumentException e) {
			}
		}
	}

	public void showProduct() {
		String idAsString = askProductId();
		if (getController().getProductsHashMap().get(idAsString) != null) {
			JOptionPane.showMessageDialog(null,
					getController().getProductsHashMap().get(idAsString).getProductId() + ": "
							+ getController().getProductsHashMap().get(idAsString).getProductTitle() + " - "
							+ getController().getProductsHashMap().get(idAsString).getProductType());
		} else {
			JOptionPane.showMessageDialog(null, "Product not found, are you sure you did enter the right product id?");
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

	public void showPrice() {
		String id = askProductId();

		if (getController().getProductsHashMap().get(id) != null) {
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
			JOptionPane.showMessageDialog(null, getController().getPrice(Integer.parseInt(id), days));
		} else {
			JOptionPane.showMessageDialog(null, "Not found");
		}
	}

	public void rentProduct() {
		String id = askProductId();
		if (getController().getProductsHashMap().get(id) != null) {
			getController().getProductsHashMap().get(id).rent();
		} else {
			JOptionPane.showMessageDialog(null, "This id doesn't match with a product.");
		}
	}

	public static void listProducts() {
		String output = "";
		try {
			for (Product product : getController().getProductsHashMap().values()) {
				output += product.toString() + "\n";
			}
			if(output.equals("")){
				throw new NullPointerException();
			}
			JOptionPane.showMessageDialog(null, output);
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Geen producten aanwezig.");
		}
	}

	public void loanProduct() {
		String id = askProductId();
		if (controller.getProductsHashMap().get(id) != null) {
			Product product = controller.getProductsHashMap().get(id);
			product.rent();
		}
	}

	public void collectProduct() {
		String id = askProductId();
		if (controller.getProductsHashMap().get(id) != null) {
			Product product = controller.getProductsHashMap().get(id);
			JOptionPane.showConfirmDialog(null, "Is this product broken?");

			// product.bringBack(broken);
		}
	}

	public void getProductStatus() {
		String id = askProductId();
		if (getController().getProductsHashMap().get(id) != null) {
			String status = getController().getProductsHashMap().get(id).isBeschikbaar() ? "Available" : "Unavaileble";
			JOptionPane.showMessageDialog(null, "The product status of "
					+ getController().getProductsHashMap().get(id).getProductTitle() + " is " + status);
		}
	}

	public static void saveProducts() {
		getController().saveToFile();
	}

}
