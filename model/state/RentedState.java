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
		JOptionPane.showInternalMessageDialog(null, "This product is already rentend so you can't rent this again.");	
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
			JOptionPane.showMessageDialog(null, "This product is damaged.");
		}else{

		}
		
	}
	public Product getProduct(){
		return product;
	}
	}
