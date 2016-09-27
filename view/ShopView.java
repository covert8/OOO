package view;

import javax.swing.*;

/**
 * Created by louis on 21/09/2016.
 */
public class ShopView {
	public double getPrice(int productidx, int days) {
		
	}

	public static void main(String[] args) {
		String menu = "1. Add product\n2. Show product\n3. Show rental price\n\n0. Quit";
		int choice = -1;
		while (choice != 0) {
			String choiceString = JOptionPane.showInputDialog(menu);
			choice = Integer.parseInt(choiceString);
			if (choice == 1) {
				addProduct(shop);
			} else if (choice == 2) {
				showProduct(shop);
			} else if (choice == 3){
				showPrice(shop);
			}
		}
	}

	public static void addProduct(Shop shop) {
		String title = JOptionPane.showInputDialog("Enter the title:");
		String id = JOptionPane.showInputDialog("Enter the id:");
		String type = JOptionPane.showInputDialog("Enter the type (M for movie/G for game):");

		shop.productTitles.add(title);
		shop.productIds.add(id);
		shop.productTypes.add(type);
	}

	public static void showProduct(Shop shop){
		String id = JOptionPane.showInputDialog("Enter the id:");
		int idx = -1;
		boolean found = false;
		for(int i = 0; i < shop.productIds.size() && !found; i++)
		{
			if(shop.productIds.get(i).equals(id))
			{
				idx = i;
				found = true;
			}
		}
		if(found)
		{
			JOptionPane.showMessageDialog(null, shop.productTitles.get(idx));
		}
	}

	public static void showPrice(Shop shop){
		String id = JOptionPane.showInputDialog("Enter the id:");
		int idx = -1;
		boolean found = false;
		for(int i = 0; i < shop.productIds.size() && !found; i++){
			if(shop.productIds.get(i).equals(id)){
				idx = i;
				found = true;
			}
		}
		if(found){
			String daysString = JOptionPane.showInputDialog("Enter the number of days:");
			int days = Integer.parseInt(daysString);
			JOptionPane.showMessageDialog(null, shop.getPrice(idx,days));
		}
	}
}
