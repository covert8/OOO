package model.rentable;

public interface Rentable {
	public boolean isRented = false;
	public void getPrice();
	public boolean getRented();
	public void setRented(boolean isRented);
}
