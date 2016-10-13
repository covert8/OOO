package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ToDatabase implements Persistable{


	@Override
	public void init()
	{

	}

	@Override
	public void save(ShopController shopController)
	{
		shopController.getProductsHashMap().values().parallelStream().forEach(dbInterface::addProduct);
		shopController.getCustomerHashMap().values().parallelStream().forEach(dbInterface::addCustomer);
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
