package model;

public interface Rentable {
	public boolean isRented = false;
	public void getPRice();
	public boolean getRented();
	public void setRented(boolean isRented);
}
