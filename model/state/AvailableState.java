package model.state;

import javax.swing.JOptionPane;

import org.apache.derby.catalog.GetProcedureColumns;

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
	}

	@Override
	public void bringback(boolean isDamaged) {
		JOptionPane.showMessageDialog(null, "You can't bring a product back a product that is availabe to rent.");
	}

	@Override
	public void repair() {
		
	}

	@Override
	public void remove() {
		
	}
	public Product getProduct(){
		return product;
	}
	
	
}
