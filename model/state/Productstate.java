package model.state;

public interface Productstate {
	

	public void rent();
	
	public void bringback(boolean isDamaged);
	
	public void repair();
	
	public void remove();

}
