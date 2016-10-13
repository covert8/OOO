package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.product.Product;

import java.util.HashMap;

public class ToDatabase implements Persistable{


	@Override
	public void init()
	{

	}

	@Override
	public void save(ShopController shopController)
	{

	}

	@Override
	public HashMap<String, Product> loadProducts()
	{
		return null;
	}

	@Override
	public HashMap<String, Customer> loadCustomers()
	{
		return null;
	}
}
