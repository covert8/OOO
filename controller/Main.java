package controller;

import javax.swing.JOptionPane;

import view.ShopView;

public class Main {
	public static void main(String[] args) {
	
		String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Rent Prodocut\n 5. List all products \n6. Save all products \n7. Loan prodcut\n8. Collect product \n9. Check productstatus\n10 add from File\n\n0. Quit";
		int choice = -1;
		ShopView view = new ShopView();
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
						view.listProcducts();
						break;
					case 6:
						view.saveProducts();
						break;
					case 7:
						view.loanProduct();
						break;
					case 8:
						view.collectProduct();
						break;
					case 9: view.getProductStatus();
					break;
					case 10: view.uploadProducts();
						break;
				case 0:
						break;		
				default:
						throw new IllegalArgumentException("Invalid input");
					}
				} catch (IllegalArgumentException e) {
					view.showError(e);
				} catch (NullPointerException e) {
				}
			}
		}
	}

}
