package view;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.Control;
import javax.swing.*;
import controller.ShopController;
import model.Product;

/**
 * Created by louis on 21/09/2016.
 */
public class ShopView {

	private static ShopController controller = new ShopController("I dont care");

	public double getPrice(int productidx, int days) {
		return controller.getPrice(productidx, days);
	}

	public static void rentProduct() {
		// TODO: impl: rental product
	}

	public static void listProcducts() {
		String output = "";
		for (Product product : controller.getProducts()) {
			output += product.getProductId() + ": " + product.getProductTitle() + "\n";
		}
		JOptionPane.showMessageDialog(null, output);
	}

	public static void saveProducts() {
		// TODO impl saveProduct
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
		int id = rand.nextInt(90000) + 10000;
		controller.addProduct(title, ""+id, type);
		JOptionPane.showMessageDialog(null,"The random generated ID is " + id);
	}

	public void showProduct() {
		String idAsString = JOptionPane.showInputDialog("Enter the id:");
		int id;
		try{
			id = Integer.parseInt(idAsString);
			if(id < 0){
				throw new IllegalArgumentException("Give a positive number");
			}
		} catch(NumberFormatException e){
			throw new IllegalArgumentException("Give a number");
		}
		int idx = -1;
		boolean found = false;
		for (int i = 0; i < controller.getProducts().size() && !found; i++) {
			if (controller.getProducts().get(i).getProductId().equals(""+id)) {
				idx = i;
				found = true;
			}
		}
		if (found) {
			JOptionPane.showMessageDialog(null, controller.getProducts().get(idx).getProductTitle());
		}else{
			JOptionPane.showMessageDialog(null,"The numbers, Jason, what do they mean??");
			JOptionPane.showMessageDialog(null,"Jk, Product not found");
		}
	}

	public void showPrice() {
		String idAsString = JOptionPane.showInputDialog("Enter the id:");
		int id;
		try{
			id = Integer.parseInt(idAsString);
			if(id < 0){
				throw new IllegalArgumentException("Give a positive number");
			}
		} catch(NumberFormatException e){
			throw new IllegalArgumentException("Give a number");
		}
		int idx = -1;
		boolean found = false;
		for (int i = 0; i < controller.getProducts().size() && !found; i++) {
			if (controller.getProducts().get(i).getProductId().equals(""+id)) {
				idx = i;
				found = true;
			}
		}
		if (found) {
			String daysString = JOptionPane.showInputDialog("Give the amount of days");
			int days;
			try{
				days = Integer.parseInt(daysString);
				if(days < 0){
					throw new IllegalArgumentException("Give a positive number");
				}
			} catch(NumberFormatException e){
				throw new IllegalArgumentException("Give a number");
			}
			JOptionPane.showMessageDialog(null, controller.getPrice(idx, days));
		}else{
			JOptionPane.showMessageDialog(null,"Not found");
		}
	}

	public void showError(Exception e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
}
