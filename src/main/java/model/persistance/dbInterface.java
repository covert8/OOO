package model.persistance;

import model.client.Customer;
import model.product.CD;
import model.product.Game;
import model.product.Movie;
import model.product.Product;

import javax.swing.*;
import java.sql.*;
import java.util.LinkedList;

final class dbInterface
{
	private static String createTableProductScript =
			"CREATE TABLE products "
					+ "( productid INT NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ " producttitle VARCHAR(100) NOT NULL, "
					+ " producttype VARCHAR(1) NOT NULL, "
					+ " productid VARCHAR(1) NOT NULL,"
					+ " creationdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ) " ;
	private static String createTableCustomerScript =
			"CREATE TABLE customers "
					+ "( customerid INT NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ " customername VARCHAR(100) NOT NULL, "
					+ " customeremail VARCHAR(1) NOT NULL, "
					+ " creationdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ) " ;

	private static String driver = "org.apache.derby.jdbc.ClientDriver";
	private static String connectionURL = "jdbc:derby:OOODB;create=true";
	private static Connection connexion;

	private static void loadDriver() {
		try {
			Class.forName(driver);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	/*
	* Connection to derbyDB
	*/
	private static void makeConnection() {
		try {
			loadDriver();
			connexion = DriverManager.getConnection(connectionURL);
			//System.out.println("successfully connected to derbyDB");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void createTables() {
		try {
			Statement sItemTable = connexion.createStatement();
			System.out.println(" . . . . creating table ItemTable");
			sItemTable.execute(createTableProductScript);
			sItemTable.execute(createTableCustomerScript);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static void addProduct(Product product)
	{
		try
		{
			makeConnection();
			String requeteAddItem =
					"insert into products(producttitle,producttype,productid) values (?,?)";
			PreparedStatement pst = connexion.prepareStatement(requeteAddItem);
			pst.setString(1, product.getProductTitle());
			pst.setString(2, product.getProductType());
			pst.setString(3, product.getProductId());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Item added");
			pst.close();
			connexion.close();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	static void addCustomer(Customer customer) {
		try {
			makeConnection();
			String requeteAddItem =
					"insert into customers(customername,customeremail) values (?,?)";
			PreparedStatement pst= connexion.prepareStatement(requeteAddItem);
			pst.setString(1, customer.getName());
			pst.setString(2, customer.getEmail());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null,"Item added");
			pst.close();
			connexion.close();
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}

	static LinkedList<Product> getProducts()
	{
		LinkedList<Product> resultsList = new LinkedList<>();
		try
		{
			Statement stmt = connexion.createStatement();
			ResultSet results = stmt.executeQuery("select * from products");
			ResultSetMetaData rsmd = results.getMetaData();

			while(results.next())
			{
				//id title and type
				LinkedList<Product> temp = new LinkedList<>();
				String id = results.getString(4);
				String title = results.getString(2);
				String type = results.getString(3);
				switch (type)
				{
					case "CD":
						temp.add(new CD(title,id));
						break;
					case "Game":
						temp.add(new Game(title,id));
						break;
					case "Movie":
						temp.add(new Movie(title,id));
						break;
					default:
						throw new IllegalArgumentException("Product type not expected");
				}
				resultsList.addAll(temp);
			}
			results.close();
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
		return resultsList;
	}

	static LinkedList<Customer> getCustomers()
	{
		LinkedList<Customer> resultsList = new LinkedList<>();
		try
		{
			Statement stmt = connexion.createStatement();
			ResultSet results = stmt.executeQuery("select * from customers");
			ResultSetMetaData rsmd = results.getMetaData();

			while(results.next())
			{
				String id = results.getString(1);
				String name = results.getString(2);
				String email= results.getString(3);

				resultsList.add(new Customer(name,email));
			}
			results.close();
			stmt.close();
		}
		catch (SQLException sqlExcept)
		{
			sqlExcept.printStackTrace();
		}
		return resultsList;
	}

}
