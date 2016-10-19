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
	private JButton quit;
		
	public ShopUI(){
		addElements();
	}
	public void addElements() {	
		JPanel content = new JPanel();
		content.setLayout(new GridLayout(8, 1));
		JButton addProduct = new JButton("Add Product");
		addProduct.addActionListener(new ShopHandler());
		content.add(addProduct);
		JButton ShowProduct = new JButton("Show Product");
		ShowProduct.addActionListener(new ShopHandler());
		content.add(ShowProduct);
		JButton showProducts = new JButton("Show Products");
		showProducts.addActionListener(new ShopHandler());
		JButton showRentalPrice = new JButton("Show rental price");
		showRentalPrice.addActionListener(new ShopHandler());
		content.add(showRentalPrice);
		JButton rentProduct = new JButton("Rent prodcut");
		rentProduct.addActionListener(new ShopHandler());
		content.add(rentProduct);
		JButton returnProduct = new JButton("Return product");
		returnProduct.addActionListener(new ShopHandler());
		content.add(returnProduct);
		JButton subscribe = new JButton("Subscripe to newsletter");
		subscribe.addActionListener(new ShopHandler());
		content.add(subscribe);
		JButton unsubscribe = new JButton("Unsubscribe");
		unsubscribe.addActionListener(new ShopHandler());
		content.add(unsubscribe);
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ShopHandler());
		content.add(quit);
		add(content);
		this.pack();
		this.setVisible(true);
		
	}
}
