package controller;

import javax.swing.JOptionPane;
import view.ShopView;

public class Main {
	public static void main(String[] args) {
		
		String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Rent Product\n 5. List all products \n6. Change persitible option \n7. Loan prodcut\n8. Collect product \n9. Check productstatus\n\n0. Quit";
		int choice = -1;
		ShopView view = new ShopView();
		view.askPersistentOption();
		while (choice != 0) {
			String choiceString = JOptionPane.showInputDialog(menu);
			if (choiceString == null || choiceString.isEmpty()) {
				choice = 0;
			} else {
				try {
					choice = Integer.parseInt(choiceString);
					switch (choice) {
					case 1:
						view.addProduct();
						break;
					case 2:
						view.showProduct();
						break;
					case 3:
						view.showPrice();
						break;
					case 4:
						view.rentProduct();
						break;
					case 5:
						ShopView.listProducts();
						break;
					case 6:
						view.askPersistentOption();
						break;
					case 7:
						ShopView.loanProduct();
						break;
					case 8:
						ShopView.collectProduct();
						break;
					case 9: view.getProductStatus();
						break;
				case 0:
						ShopView.saveProducts();
						break;		
				default:
						throw new IllegalArgumentException("Invalid input");
					}
				} catch (IllegalArgumentException e) {
					view.showError(e);
				} catch (NullPointerException ignored) {
				}
			}
		}
	}

}
