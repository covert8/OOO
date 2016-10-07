package model;

import java.util.HashMap;

public class ToDatabase implements Persistable{

	@Override
	public void save(HashMap<String, Product> productList) {
		//TODO: setup derby db save
	}

	@Override
	public void load(HashMap<String, Product> productList) {
		// TODO setup derby db load
	}

}
