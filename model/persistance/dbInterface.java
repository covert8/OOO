package model.persistance;

import model.client.Customer;
import model.product.Product;

import javax.swing.*;
import java.sql.*;

public final class dbInterface
{
	public static String createTableProductScript =
			"CREATE TABLE products "
					+ "( productid INT NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ " producttitle VARCHAR(100) NOT NULL, "
					+ " producttype VARCHAR(1) NOT NULL, "
					+ " creationdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ) " ;
	public static String createTableCustomerScript =
			"CREATE TABLE customers "
					+ "( customerid INT NOT NULL primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), "
					+ " customername VARCHAR(100) NOT NULL, "
					+ " customeremail VARCHAR(1) NOT NULL, "
					+ " creationdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ) " ;

	public static String driver = "org.apache.derby.jdbc.ClientDriver";
	public static String connectionURL = "jdbc:derby:JavaPracticumHerkansingDB;create=true";
	public static Connection connexion = null;

	public static void loadDriver() {
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
	public static void makeConnection() {
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

	public static void addProduct(Product product)
	{
		try
		{
			makeConnection();
			String requeteAddItem =
					"insert into products(producttitle,producttype) values (?,?)";
			PreparedStatement pst = connexion.prepareStatement(requeteAddItem);
			pst.setString(1, product.getProductTitle());
			pst.setString(2, product.getProductType());
			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Item added");
			pst.close();
			connexion.close();
		} catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
	public static void addCustomer(Customer customer) {
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

}
