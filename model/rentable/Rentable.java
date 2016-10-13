package model.rentable;

public interface Rentable {
	public boolean isRented = false;
	public double getPrice(int iAantalDagen);
	public boolean getRented();
	public void setRented(boolean isRented);
}
