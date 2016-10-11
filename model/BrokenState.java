package model;

import javax.swing.JOptionPane;

public class BrokenState  implements Productstate{

	@Override
	public void rent() {
		JOptionPane.showInternalMessageDialog(null,"This product is damaged, you can't rent it.");
	}


	@Override
	public void repair() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bringback(boolean isDamaged) {
		// TODO Auto-generated method stub
		
	}

}
