package model.product;

import model.persistance.Dumpable;
import model.state.AvailableState;
import model.state.ProductState;

public abstract class Product implements Dumpable
{
	private final String productTitles;
	private final String productId;
	private boolean bBeschikbaar = true;
	private ProductState state;

	Product(String productTitles, String productIds) {
		this.productTitles = productTitles;
		this.productId = productIds;
		//this.bBeschikbaar = beschikbaar;
		this.setCurrentProductState(new AvailableState(this));
	}
/*
	@Deprecated
	Product(String productTitles, String productIds) {
		this.productTitles = productTitles;
		this.productId = productIds;
	}
*/
	public String getProductTitle() {
		return productTitles;
	}

	 public abstract String getProductType();

	public boolean isBeschikbaar() {
		return bBeschikbaar;
	}

	public void setBeschikbaar(boolean bBeschikbaar) {
		this.bBeschikbaar = bBeschikbaar;
	}

	public String dump()
	{
		String output = "";
		output+=getProductId()+",";
		output+=getProductTitle()+",";
		output+=getProductType()+",";
		output+="\n";
		return output;
	}
	public double getPrice(){
		//TODO impl getPrice
			return 0;
	}

	public String getProductId() {
		return productId;
	}
	public ProductState getCurrentProductState(){
		return state;
	}
	public void setCurrentProductState(ProductState state){
		this.state = state;
	}
	public void repair(){
		getCurrentProductState().repair();
	}
	public void remove(){
		getCurrentProductState().remove();
	}
	public void rent(){
		getCurrentProductState().rent();
	}
	public void bringBack(boolean broken){
		getCurrentProductState().rent();
	}
	public String toString(){
		return getProductTitle();
		
	}
}
