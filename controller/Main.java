package controller;

import view.ShopUI;
import view.ShopView;
import view.StartupOptions;

public class Main {
	private static ShopController controller;

	public static void main(String[] args) {

		controller = new ShopController();
		StartupOptions startup = new StartupOptions(controller);
		startup.askPersistentOption();
		String inputOption = startup.askInputOption();
		ShopUI ui;
		ShopView view;
		switch (inputOption) {
		case "UI":
			ui = new ShopUI();
			break;
		case "OptionPane":
			view = new ShopView(controller);
			view.run();
			break;
		default:
			break;

		// ui.dispose();
		}
	}

}
