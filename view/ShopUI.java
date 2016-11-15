package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.ShopController;

/**
 * 
 * @author yanice
 *
 */
public class ShopUI extends UI{

	private JPanel content;
	private ShopController controller;
	private JButton addProduct;
	private JButton showProduct;
	private JButton showProducts;
	private JButton showRentalPrice;
	private JButton rentProduct;
	private JButton returnProduct;
	private JButton subscribe;
	private JButton unsubscribe;
	private JButton quit;
	private JFrame frame;
	public ShopUI(ShopController controller) {
		super(controller);
		createElements();
		addHandlers();
		addElements();
		create();
	}

	private void createElements() {
		frame = new JFrame();
		content = new JPanel();
		content.setLayout(new GridLayout(9, 1));
		addProduct = new JButton("Add Product");
		showProduct = new JButton("Show Product");
		showProducts = new JButton("Show Products");
		showRentalPrice = new JButton("Show rental price");
		rentProduct = new JButton("Rent product");
		returnProduct = new JButton("Return product");
		subscribe = new JButton("Subscripe to newsletter");
		unsubscribe = new JButton("Unsubscribe");
		quit = new JButton("Quit");
	}

	private void addHandlers() {
		addProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addProduct();
			}
		});
		showProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showProduct();
			}
		});
		showProducts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listProducts();
			}
		});
		showRentalPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showPrice();
			}
		});
		rentProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loanProduct();
			}
		});
		returnProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				returnProduct();
			}
		});
		subscribe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("nop");
			}
		});
		unsubscribe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ShopView.saveProducts();
				frame.dispose();
			}
		});
	}

	private void addElements() {
		content.add(addProduct);
		content.add(showProduct);
		content.add(showProducts);
		content.add(showRentalPrice);
		content.add(rentProduct);
		content.add(returnProduct);
		content.add(subscribe);
		content.add(unsubscribe);
		content.add(quit);
		frame.add(content);
	}

	private void create() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
