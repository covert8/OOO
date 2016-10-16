package model.state;

import javax.swing.JOptionPane;

import model.product.Product;

public class BrokenState  implements ProductState
{
	private Product product;
	public BrokenState(Product product){
		this.product = product;
	}

	@Override
	public void rent() {
		JOptionPane.showInternalMessageDialog(null,"This product is damaged, you can't rent it.");
	}


	@Override
	public void repair() {
		
	}

	@Override
	public void remove() {
		
	}

	@Override
	public void bringback(boolean isDamaged) {
		JOptionPane.showMessageDialog(null, "You can't bring a poduct back that is already in our prossesion.");
	}
	public Product getProduct(){
		return product;
	}

}
