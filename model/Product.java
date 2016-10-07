package model;

import java.io.Serializable;

public abstract class Product implements Serializable{
	private Readable rentable;
	private String productTitles;
	private String productId;
	private boolean bBeschikbaar = false;
	

	Product(String productTitles, String productIds,boolean beschikbaar) {
		this.productTitles = productTitles;
		this.productId = productIds;
		this.bBeschikbaar = beschikbaar;
	}
	
	Product(String productTitles, String productIds) {
		this.productTitles = productTitles;
		this.productId = productIds;
	}

	public String getProductTitle() {
		return productTitles;
	}

	 public String getProductType(){
		 return this.getClass().getSimpleName();
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
		output+=productId+", ";
		output+=bBeschikbaar;
		return output;
	}
	public double getPrice(){
		//TODO impl getPrice
			return 0;
	}

	public String getProductId() {
		return productId;
	}
}
