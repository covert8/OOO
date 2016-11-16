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
	private JButton createCustomer;
	private JButton subscribe;
	private JButton unsubscribe;
	private JButton quit;
	private JFrame frame;
	public ShopUI(ShopController controller) {
		super(controller);
		createElements();
		addHandlers();
		addElements();
	}

	private void createElements() {
		frame = new JFrame();
		content = new JPanel();
		content.setLayout(new GridLayout(10, 1));
		addProduct = new JButton("Add Product");
		showProduct = new JButton("Show Product");
		showProducts = new JButton("Show Products");
		showRentalPrice = new JButton("Show rental price");
		rentProduct = new JButton("Rent product");
		returnProduct = new JButton("Return product");
		createCustomer = new JButton("Create Customer");
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
		createCustomer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createCustomer();
			}
		});
		subscribe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				subscribeCustomer();
			}
		});
		unsubscribe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				unSubscribeCustomer();
			}
		});
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
				ShopView.saveProducts();
				} catch (Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
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
		content.add(createCustomer);
		content.add(subscribe);
		content.add(unsubscribe);
		content.add(quit);
		frame.add(content);
	}

	@Override
	public void run() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
