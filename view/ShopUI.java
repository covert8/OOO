package view;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author yanice
 *
 */
public class ShopUI extends JFrame{
	
	public ShopUI(){
		createMenu();
	}
	public void createMenu() {	
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(6, 1));
		JButton addProduct = new JButton("Add Product");
		content.add(addProduct);
		JButton ShowProduct = new JButton("Show Product");
		content.add(ShowProduct);
		JButton showProducts = new JButton("Show Products");
		content.add(showProducts);
		JButton showRentalPrice = new JButton("Show rental price");
		content.add(showRentalPrice);
		JButton subscribe = new JButton("Subscripe to newsletter");
		content.add(subscribe);
		JButton unsubscribe = new JButton("Unsubscribe");
		content.add(unsubscribe);
		add(content);
		this.pack();
		this.setVisible(true);
		
	}
}
