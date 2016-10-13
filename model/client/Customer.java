package model.client;

import model.persistance.Dumpable;

public class Customer implements Dumpable
{
	private String name;

	@Override
	public String dump()
	{
		return null;
	}

	public String getName()
	{
		return name;
	}
}
