package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author yanice
 *
 */
public class ShopUI extends JFrame {

	private JPanel content;

	private JButton addProduct;
	private JButton showProduct;
	private JButton showProducts;
	private JButton showRentalPrice;
	private JButton rentProduct;
	private JButton returnProduct;
	private JButton subscribe;
	private JButton unsubscribe;
	private JButton quit;

	public ShopUI() {
		createElements();
		addHandlers();
		addElements();
		create();
	}

	private void createElements() {
		content = new JPanel();
		content.setLayout(new GridLayout(9, 1));
		addProduct = new JButton("Add Product");
		showProduct = new JButton("Show Product");
		showProducts = new JButton("Show Products");
		showRentalPrice = new JButton("Show rental price");
		rentProduct = new JButton("Show rental price");
		returnProduct = new JButton("Show rental price");
		subscribe = new JButton("Subscripe to newsletter");
		unsubscribe = new JButton("Unsubscribe");
		quit = new JButton("Quit");
	}

	private void addHandlers() {
		addProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		showProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		showProducts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		showRentalPrice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		rentProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		returnProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
			}
		});
		subscribe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hello");
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
				System.out.println("hello");
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
		add(content);
	}

	private void create() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
