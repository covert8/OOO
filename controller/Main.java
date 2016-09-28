package controller;

import javax.swing.JOptionPane;
import view.ShopView;

public class Main {
	public static void main(String[] args) {
		String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Rent Prodocut\n 5. List all products \n6. Save all products \n7. Loan prodcut\n8. Collect product \n\n0. Quit";
		int choice = -1;
		while (choice != 0) {
			String choiceString = JOptionPane.showInputDialog(menu);
			choice = Integer.parseInt(choiceString);
			ShopView view = new ShopView();
			switch (choice){
				case 1: view.addProduct();
						break;
				case 2: view.showProduct();
						break;
				case 3: view.showPrice();
						break;
				case 4: view.rentProduct();
						break;
				case 5: view.listProcducts();
						break;
				case 6: view.saveProducts();
						break;
				case 7: view.saveProducts();
						break;
				case 8: view.collectProduct();
						break;
				default:
						break;
			}
		
		}
	}

}
