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
<<<<<<< HEAD
	
	private JPanel content;
	private JButton addProduct;
	private JButton ShowProduct;
	private JButton showProducts;
	private JButton showRentalPrice;
	private JButton rentProduct;
	private JButton returnProduct;
	private JButton subscribe;
	private JButton unsubscribe;
	
=======
	private JButton quit;
>>>>>>> bab5490937725df13371364e0341af243e6f90e6
		
	public ShopUI(){
		createElements();
		addHandlers();
		addElements();
		create();
	}
<<<<<<< HEAD
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
=======
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
>>>>>>> bab5490937725df13371364e0341af243e6f90e6
		subscribe.addActionListener(new ShopHandler());
		unsubscribe.addActionListener(new ShopHandler());
	}
	
	private void addElements(){
		content.add(addProduct);
		content.add(ShowProduct);
		content.add(showRentalPrice);
		content.add(subscribe);
		content.add(unsubscribe);
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ShopHandler());
		content.add(quit);
		add(content);
	}
	private void create(){
		this.pack();
		this.setVisible(true);
	}
}
