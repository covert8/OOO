package model.state;

import javax.swing.JOptionPane;

import model.product.Product;

public class RentedState implements ProductState
{
	private Product product;
	public RentedState(Product product){
		this.product = product;
	}
	@Override
	public void rent() {
		JOptionPane.showMessageDialog(null, "This product is already rentend so you can't rent this again.");	
	}

	@Override
	public void repair() {
		JOptionPane.showMessageDialog(null, "This product is not in our possession. So we can't repair it.");
		
	}

	@Override
	public void remove() {
		JOptionPane.showMessageDialog(null, "This product is not in our possession. So we can't remove it.");
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
	public Product getProduct(){
		return product;
	}
	public String toString()
	{
		return "Rented";
	}
}
