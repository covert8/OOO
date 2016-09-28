package view;

import javax.swing.*;
import controller.ShopController;

/**
 * Created by louis on 21/09/2016.
 */
public class ShopView {
	
	private ShopController controller = new ShopController();

	public double getPrice(int productidx, int days) {
		return controller.getPrice(productidx, days);
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
	public void addProduct() {
		String title = JOptionPane.showInputDialog("Enter the title:");
		String id = JOptionPane.showInputDialog("Enter the id:");
		String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

		controller.addProduct(title,id,type);
	}

	public void showProduct(){
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

	public void showPrice(){
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
