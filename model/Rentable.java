package model;

public interface Rentable {
	static double iPrijsPerDag = 1.5;
	static double getPrice(int iDag)
	{
		return iPrijsPerDag*iDag;
	}
}
