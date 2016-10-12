package model.persistance;

import model.product.Product;

import java.util.HashMap;

public class ToDatabase implements Persistable{

	@Override
	public void save(HashMap<String, Product> productList) {
		//TODO: setup derby db save
	}

	@Override
	public HashMap<String, Product> load() {
		// TODO setup derby db load
		return null;
	}

	@Override
	public void init() {
		//TODO create database tables
		
	}

}
