package model;

public interface Rentable {
	static double getPrice(int iDag)
	{
		return 1.5*iDag;
	}
}
