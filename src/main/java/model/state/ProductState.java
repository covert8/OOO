package model.state;

public interface ProductState
{
	public void rent();
	
	public void bringback(boolean isDamaged);
	
	public void repair();
	
	public void remove();

}
