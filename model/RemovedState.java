package model;

public class RemovedState implements Productstate{

	public  RemovedState(Product product) {
		
		product.setCurrentProductState(this);
	}
	
	@Override
	public void rent() {
		// TODO Auto-generated method stub
		
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
