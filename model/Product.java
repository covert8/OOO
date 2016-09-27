package model;

import java.util.ArrayList;

/**
 * Created by louis on 27/09/2016.
 */
public class Product {
	public Product(String productTitles, String productTypes, String productIds) {
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
	}

	public String getProductTitles() {
		return productTitles;
	}

	public String getProductTypes() {
		return productTypes;
	}

	public String getProductIds() {
		return productIds;
	}

	private String productTitles;
	private String productTypes;
	private String productIds;
}
