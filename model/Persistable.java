package model;

import java.util.HashMap;

public interface Persistable {

	public  void save(HashMap<String, Product> productList);
	public  void load(HashMap<String, Product> productList);

}
