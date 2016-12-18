package view;

import controller.ShopController;

import javax.swing.*;

public class StartupOptions {

	private static ShopController controller;

	public StartupOptions(ShopController controller) {
		StartupOptions.controller = controller;
	}

	public void askPersistentOption() {
		//TODO zou via view moeten.
		String selectedString = "";
		String[] values = { "Database", "Text file", "Excel sheet" };
		Object selected = JOptionPane.showInputDialog(null, "Which persitible option doe you want to use?", "Selection",
				JOptionPane.DEFAULT_OPTION, null, values, "Database");
		if (selected != null) {
			selectedString = selected.toString();
			controller.setPersitible(selectedString);
			System.out.println(selectedString);
			switch (selectedString) {
				case "Text file":
					controller.reloadFromPersister();
					break;
				case "Database":
					break;
				case "Excel sheet":
					break;
				default:
					break;
			}
		} else {
			JOptionPane.showMessageDialog(null, "You need to select an option!");
			askPersistentOption();
		}

	}

	public String askInputOption(){
		String selectedString = "";
		String[] values = { "UI", "OptionPane" };
		Object selected = JOptionPane.showInputDialog(null, "Which persitible option doe you want to use?", "Selection",
				JOptionPane.DEFAULT_OPTION, null, values, "Database");
		if (selected != null) {
			selectedString = selected.toString();
			System.out.println(selectedString);
			return selectedString;
		} else {
			JOptionPane.showMessageDialog(null, "You need to select an option!");
			return(askInputOption());
		}
	}

}
