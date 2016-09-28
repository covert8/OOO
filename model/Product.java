package model;

import com.sun.xml.internal.bind.v2.ClassFactory;

import java.io.Serializable;

public class Product implements Serializable{
	private String productTitles;
	private String productTypes;
	private String productIds;
	private boolean bBeschikbaar = false;

	@Deprecated
	Product(String productTitles, String productIds, String productTypes) {
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
	}

	Product(String productTitles, String productIds, String productTypes,boolean beschikbaar) {
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
		this.bBeschikbaar = beschikbaar;
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

	//TODO watch out any and all variables required
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
