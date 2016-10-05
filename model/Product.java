package model;

import java.io.Serializable;

public class Product implements Serializable{
	private String productTitles;
	private String productTypes;
	private String productIds;
	private boolean bBeschikbaar = false;
	

	Product(String productTitles, String productIds, String productTypes,boolean beschikbaar) {
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
		this.bBeschikbaar = beschikbaar;
	}
	
	Product(String productTitles, String productIds, String productTypes) {
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
		String output ="New Product\n";
		output+=productTitles+"\n";
		output+=productTypes+"\n";
		output+=productIds+"\n";
		output+=bBeschikbaar+"\n";
		output+=this.getClass() + "\n";
		return output;
	}
}
