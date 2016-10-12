package model.state;

import javax.swing.JOptionPane;

public class RentedState implements Productstate {

	@Override
	public void rent() {
		JOptionPane.showInternalMessageDialog(null, "This product is already rentend so you can't rent this again.");
		
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
		if(isDamaged){
			
		}else{

		}
		
	}

}
