package model;

import java.util.HashMap;

public interface Persistable {

	abstract void save(HashMap<String, Product> productList);
	abstract void load(HashMap<String, Product> productList);

}
