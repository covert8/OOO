package model.state;

import javax.swing.JOptionPane;

import model.product.Product;

public class HiredState implements ProductState
{
	private Product product;
	public HiredState(Product product){
		this.product = product;
	}

	@Override
	public void rent() {
		JOptionPane.showMessageDialog(null, "This product is already hired, you can't rent it again/.");
		
	}

	@Override
	public void bringback(boolean isDamaged) {
		if(isDamaged){
			JOptionPane.showMessageDialog(null, "You broke this product!");
			getProduct().setCurrentProductState(new BrokenState(getProduct()));
		}
		else{
			JOptionPane.showMessageDialog(null, "You have successfully returned this product");
			getProduct().setCurrentProductState(new AvailableState(getProduct()));
		}
	}
	@Override
	public void repair() {
		JOptionPane.showMessageDialog(null, "You can't repair a product that is Rented by someone.");
	}

	@Override
	public void remove() {
		JOptionPane.showMessageDialog(null, "You can't remove a product that is Rented by someone.");
	}
	public Product getProduct(){
		return product;
	}
	public String toString()
	{
		return "HiredState";
	}
	
}
