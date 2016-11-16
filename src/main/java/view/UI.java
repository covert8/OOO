package view;

import java.util.Random;

import javax.swing.JOptionPane;

import controller.ShopController;
import model.client.Customer;
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
			JOptionPane.showMessageDialog(null, "You should enter a title!");
			throw new IllegalArgumentException("Invalid Title");
		} else if (Character.isLowerCase(title.charAt(0))) {
			JOptionPane.showMessageDialog(null, "The first character should be uppercase!");
			throw new IllegalArgumentException("First character has to be uppercase");
		}
		String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game/ C for CD):");
		if (type.isEmpty() || !(type.equals("M") || type.equals("G") || type.equals("C"))) {
			JOptionPane.showMessageDialog(null, "You should enter a valid type!");
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

	/*
	public void rentProduct() {
		String id = askProductId();
		if (getController().getProductsHashMap().get(id) != null) {
			getController().getProductsHashMap().get(id).rent();
		} else {
			JOptionPane.showMessageDialog(null, "This id doesn't match with a product.");
		}
	}*/

	public static void listProducts() {
		String output = "";
		try {
			for (Product product : getController().getProductsHashMap().values()) {
				output += product.toString() + "\n";
			}
			if (output.equals("")) {
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
			String name = AskCustumorsName();
			if (controller.getCustomerHashMap().containsKey(name)) {
				product.rent();
			}else{
				JOptionPane.showMessageDialog(null, "User niet gevonden.");
			}
		}else{
			JOptionPane.showMessageDialog(null, "Product niet gevonden.");
		}
	}

	public String AskCustumorsName() {
		String name = JOptionPane.showInputDialog("What is the customers name?");
		return name;
	}
	
	public String AskCustumorsEmail() {
		String email = JOptionPane.showInputDialog("What is the customers email?");
		return email;
	}
	
	public void createCustomer(){
		String name = AskCustumorsName();
		String email = AskCustumorsEmail();
		controller.getCustomerHashMap().put(name, new Customer(name, email));
	}

	public void returnProduct() {
		String id = askProductId();
		if (controller.getProductsHashMap().get(id) != null) {
			Product product = controller.getProductsHashMap().get(id);
			int broken = JOptionPane.showConfirmDialog(null, "Is this product broken?", null,
					JOptionPane.YES_NO_OPTION);
			Boolean status = broken == 0 ? true : false;
			product.bringBack(status);
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

	public String askPersitibleOption() {
		return JOptionPane.showInputDialog("Which persitible type should you use? Database/file");
	}

	public void subscribeCustomer() {
		String name = AskCustumorsName();
		Customer c = controller.getCustomerHashMap().get(name);
		if (c != null) {
			controller.subscribeCustomer(c.getEmail());
		}else{
			JOptionPane.showMessageDialog(null, "We can't find a customer with that name. Please rent a product before you can subscribe to our newsletter.");
		}
	}
	public void unSubscribeCustomer() {
		String name = AskCustumorsName();
		Customer c = controller.getCustomerHashMap().get(name);
		//eamil should be in the list for unscrube
		if(c != null && controller.getMailingList().contains(c.getEmail())){
			controller.unSubscribeCustomer(c.getEmail());
		}else{
			JOptionPane.showMessageDialog(null, "We can't find a customer with that name. Please rent a product before you can subscribe to our newsletter.");

		}
	}
	
	public void run(){
	}

}
