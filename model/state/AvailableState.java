package model.state;

import javax.swing.JOptionPane;

public class AvailableState implements Productstate{

	@Override
	public void rent() {
		JOptionPane.showMessageDialog(null, "This product is available, you have sucessfully retend this product.");
	}

	@Override
	public void bringback(boolean isDamaged) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void repair() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	
	
}
