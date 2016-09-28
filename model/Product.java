package model;

public class Product {
	private String productTitles;
	private String productTypes;
	private String productIds;
	private boolean bBeschikbaar = false;

	Product(String productTitles, String productTypes, String productIds) {
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


	public boolean isBeschikbaar() {
		return bBeschikbaar;
	}

	public void setBeschikbaar(boolean bBeschikbaar) {
		this.bBeschikbaar = bBeschikbaar;
	}
}
