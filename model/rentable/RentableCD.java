package model.rentable;

public class RentableCD implements Rentable {
	//TODO impl rentable
	@Override
	public double getPrice(int iAantalDagen)
	{
		return 1.5*iAantalDagen;
	}

	@Override
	public boolean getRented() {
		return false;
	}

	@Override
	public void setRented(boolean isRented) {
		
	}

}
