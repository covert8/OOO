package controller;

import view.ShopUI;
import view.ShopView;
import view.StartupOptions;
import view.UI;

public class Main {
	private static ShopController controller;

	public static void main(String[] args) {

		controller = new ShopController();
		StartupOptions startup = new StartupOptions(controller);
		startup.askPersistentOption();
		String inputOption = startup.askInputOption();
		UI ui;
		switch (inputOption) {
		case "UI":
			ui = new ShopUI(controller);
			break;
		case "OptionPane":
			ui = new ShopView(controller);
			break;
		default:
			ui = new UI(controller);
		}
		ui.run();
	}

}
