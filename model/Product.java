package model;

import java.util.ArrayList;

public class Product {
	Product(String productTitles, String productTypes, String productIds) {
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
	}

	String getProductTitles() {
		return productTitles;
	}

	String getProductTypes() {
		return productTypes;
	}

	String getProductIds() {
		return productIds;
	}

	private String productTitles;
	private String productTypes;
	private String productIds;
}
