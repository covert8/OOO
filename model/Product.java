package model;

import java.io.Serializable;

public class Product implements Serializable{
	private Readable rentable;
	private String productTitles;
	private String productTypes;
	private String productIds;
	private boolean bBeschikbaar = false;
	

	Product(String productTitles, String productIds, String productTypes,boolean beschikbaar) {
		//TODO id, and type not as variables but with the hashmaps
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
		this.bBeschikbaar = beschikbaar;
	}
	
	Product(String productTitles, String productIds, String productTypes) {
		//TODO id, and type not as variables but with the hashmaps
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
	}

	public String getProductTitle() {
		return productTitles;
	}

	public String getProductType() {
		return productTypes;
	}

	public String getProductId() {
		return productIds;
	}


	public boolean isBeschikbaar() {
		return bBeschikbaar;
	}

	public void setBeschikbaar(boolean bBeschikbaar) {
		this.bBeschikbaar = bBeschikbaar;
	}

	public String toString()
	{
		String output = "";
		output+=productTitles+", ";
		output+=this.getClass().getSimpleName()+", ";
		output+=productIds+", ";
		output+=bBeschikbaar;
		return output;
	}
}
