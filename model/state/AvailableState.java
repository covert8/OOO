package model.state;

import javax.swing.JOptionPane;

import model.product.Product;

public class AvailableState implements ProductState
{
	private Product product;
	public AvailableState(Product product){
		this.product = product;
	}

	@Override
	public void rent() {
		JOptionPane.showMessageDialog(null, "This product is available, you have sucessfully retend this product.");
		getProduct().setCurrentProductState(new RentedState(getProduct()));
	}

	@Override
	public void bringback(boolean isDamaged) {
		JOptionPane.showMessageDialog(null, "You can't bring a product back a product that is availabe to rent.");
	}

	@Override
	public void repair() {
		JOptionPane.showMessageDialog(null, "You can't repair a product that is available.");
	}

	@Override
	public void remove() {
		JOptionPane.showMessageDialog(null, "You have successfully moved this product.");

	getProduct().setCurrentProductState(new RemovedState(getProduct()));}
	public Product getProduct(){
		return product;
	}
	public String toString()
	{
		return "AvailableState";
	}
}
