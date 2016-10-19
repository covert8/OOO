package view;

import javax.swing.JOptionPane;

import controller.ShopController;

/**
 * Created by louis on 21/09/2016.
 */
public class ShopView extends UI {

	public ShopView(ShopController controller) {
		super(controller);
	}

	public void run() {
		String menu = "1. Add product\n2. Show product\n3. Show rental price\n4. Rent Product\n 5. List all products \n6. Change persitible option \n7. Loan prodcut\n8. Collect product \n9. Check productstatus\n\n0. Quit";
		int choice = -1;
		while (choice != 0) {
			String choiceString = JOptionPane.showInputDialog(menu);
			if (choiceString == null || choiceString.isEmpty()) {
				choice = 0;
			} else {
				try {
					choice = Integer.parseInt(choiceString);
					switch (choice) {
					case 1:
						addProduct();
						break;
					case 2:
						showProduct();
						break;
					case 3:
						showPrice();
						break;
					case 4:
						rentProduct();
						break;
					case 5:
						listProducts();
						break;
					case 6:
						// askPersistentOption();
						break;
					case 7:
						loanProduct();
						break;
					case 8:
						collectProduct();
						break;
					case 9:
						getProductStatus();
						break;
					case 0:
						ShopView.saveProducts();
						break;
					default:
						throw new IllegalArgumentException("Invalid input");
					}
				} catch (IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch (NullPointerException ignored) {
				}
			}
		}
	}
}
