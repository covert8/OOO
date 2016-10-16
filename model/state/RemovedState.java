package model.state;

import javax.swing.JOptionPane;

import model.product.Product;

public class RemovedState implements ProductState
{
	private Product product;
	public RemovedState(Product product){
		this.product = product;
	}
	
	@Override
	public void rent() {
		JOptionPane.showMessageDialog(null, "You can't rent a product that is being removed.");
	}

	@Override
	public void bringback(boolean isDamaged) {
		JOptionPane.showMessageDialog(null, "You can't bring back a product that is being removed.");
	}

	@Override
	public void repair() {
		JOptionPane.showMessageDialog(null, "You can't repair a product that is being removed.");
	}

	@Override
	public void remove() {
		//TODO: impl remove
	}
	public Product getProduct(){
		return product;
	}
	

}
