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
	
	private JPanel content;
	private JButton addProduct;
	private JButton ShowProduct;
	private JButton showProducts;
	private JButton showRentalPrice;
	private JButton rentProduct;
	private JButton returnProduct;
	private JButton subscribe;
	private JButton unsubscribe;
	
		
	public ShopUI(){
		createElements();
		addHandlers();
		addElements();
		create();
	}
	private void createElements() {	
		content = new JPanel();
		content.setLayout(new GridLayout(6, 1));
		addProduct = new JButton("Add Product");
		ShowProduct = new JButton("Show Product");
		showProducts = new JButton("Show Products");
		showProducts.addActionListener(new ShopHandler());
		showRentalPrice = new JButton("Show rental price");
		rentProduct = new JButton("Show rental price");
		returnProduct = new JButton("Show rental price");
		showRentalPrice.addActionListener(new ShopHandler());
		subscribe = new JButton("Subscripe to newsletter");
		unsubscribe = new JButton("Unsubscribe");
	}
	
	private void addHandlers(){
		addProduct.addActionListener(new ShopHandler());
		ShowProduct.addActionListener(new ShopHandler());
		showRentalPrice.addActionListener(new ShopHandler());
		subscribe.addActionListener(new ShopHandler());
		unsubscribe.addActionListener(new ShopHandler());
	}
	
	private void addElements(){
		content.add(addProduct);
		content.add(ShowProduct);
		content.add(showRentalPrice);
		content.add(subscribe);
		content.add(unsubscribe);
		add(content);
	}
	private void create(){
		this.pack();
		this.setVisible(true);
	}
}
