package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.product.Product;
import java.util.HashMap;

public class ToDatabase implements Persistable{

	private static dbInterface db = new dbInterface();
	@Override
	public void init()
	{
		dbInterface.createTables();
	}

	@Override
	public void save(ShopController shopController)
	{
		init();
		shopController.getProductsHashMap().values().parallelStream().forEach(dbInterface::addProduct);
		shopController.getCustomerHashMap().values().parallelStream().forEach(dbInterface::addCustomer);
	}

	@Override
	public HashMap<String, Product> loadProducts()
	{
		HashMap<String,Product> products = new HashMap<>();
		dbInterface.getProducts().forEach(obj ->
				products.put(obj.getProductId(), obj));
		return products;
	}

	@Override
	public HashMap<String, Customer> loadCustomers()
	{
		HashMap<String,Customer> customers = new HashMap<>();
		dbInterface.getCustomers().forEach(obj ->
				customers.put(obj.getName(),obj));
		return customers;
	}
}
