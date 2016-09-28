package view;

import javax.swing.*;
import controller.ShopController;

/**
 * Created by louis on 21/09/2016.
 */
public class ShopView {
	
	private static ShopController controller = new ShopController();
	
	public static ShopController getController() {
		return controller;
	}

	public void setController(ShopController controller) {
		ShopView.controller = controller;
	}

	public double getPrice(int productidx, int days) {
		return getController().getPrice(productidx, days);
	}

	public static void main(String[] args) {
		String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Rent Prodocut\n 5. List all products \n6. Save all products \n7. Loan prodcut\n Collect product \n\n0. Quit";
		int choice = -1;
		while (choice != 0) {
			String choiceString = JOptionPane.showInputDialog(menu);
			choice = Integer.parseInt(choiceString);
			switch (choice){
				case 1: addProduct();
						break;
				case 2: showProduct();
						break;
				case 3: showPrice();
						break;
				case 4: rentProduct();
						break;
				case 5: listProcducts();
						break;
				case 6: saveProducts();
						break;
				case 7: saveProducts();
						break;
				case 8: collectProduct();
						break;
				default:
						break;
			}
		
		}
	}
	public static void rentProduct(){
		// TODO: impl: rental product
	}
	public static void listProcducts(){
		getController().listAllProducts();
	}
	public static void saveProducts(){
		//TODO impl saveProduct
	}
	public static void uploadProducts(){
		//TODO impl uploadProduct
	}
	public static void loanProduct(){
		//TODO impl loanProduct.
	}
	public static void collectProduct(){
		//TODO collectProduct
	}
	public static void addProduct() {
		String title = JOptionPane.showInputDialog("Enter the title:");
		String id = JOptionPane.showInputDialog("Enter the id:");
		String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

		getController().addProduct(title,id,type);
	}

	public static void showProduct(){
		String id = JOptionPane.showInputDialog("Enter the id:");
		int idx = -1;
		boolean found = false;
		for(int i = 0; i < controller.getProducts().size() && !found; i++)
		{
			if(controller.getProducts().get(i).getProductIds().equals(id))
			{
				idx = i;
				found = true;
			}
		}
		if(found)
		{
			JOptionPane.showMessageDialog(null, controller.getProducts().get(idx).getProductTitles());
		}
	}

	public static void showPrice(){
		String id = JOptionPane.showInputDialog("Enter the id:");
		int idx = -1;
		boolean found = false;
		for(int i = 0; i <controller.getProducts().size() && !found; i++){
			if(controller.getProducts().get(i).getProductIds().equals(id)){
				idx = i;
				found = true;
			}
		}
		if(found){
			String daysString = JOptionPane.showInputDialog("Enter the number of days:");
			int days = Integer.parseInt(daysString);
			JOptionPane.showMessageDialog(null, controller.getPrice(idx,days));
		}
	}
}
