package model;

import java.util.HashMap;

public interface Persistable {
	
	public void init();
	public  void save(HashMap<String, Product> productList);
	public  HashMap<String, Product> load();

}
