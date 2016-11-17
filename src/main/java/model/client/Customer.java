package model.client;

import model.persistance.Dumpable;

public class Customer implements Dumpable {
	private final String name;
	private final String email;

	public Customer(String name, String email)
	{
		this.name = name;
		this.email = email;
	}

	@Override
	public String dump()
	{
		String output = "";
		output+=getName()+",";
		output+=getEmail()+",";
		output+="Customer"+",";
		output+="\n";
		return output;
	}

	public String getName()
	{
		return name;
	}

	public String getEmail()
	{
		return email;
	}

}



