package model.state;

import javax.swing.JOptionPane;

public class HiredState implements ProductState
{

	@Override
	public void rent() {
		JOptionPane.showMessageDialog(null, "This product is already hired, you can't rent it again/.");
		
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
