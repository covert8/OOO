package model;

import java.util.ArrayList;

/**
 * Created by louis on 21/09/2016.
 */
public class ShopModel {
	private ArrayList<String> productTitles;
	private ArrayList<String> productTypes;
	private ArrayList<String> productIds;

	public ShopModel(ArrayList<String> productTitles, ArrayList<String> productTypes, ArrayList<String> productIds) {
		this.productTitles = productTitles;
		this.productTypes = productTypes;
		this.productIds = productIds;
	}

	public String getProductTitles(int i)
	{
		return productTitles.get(i);
	}

	public String getProductTypes(int i)
	{
		return productTypes.get(i);
	}

	public String getProductIds(int i)
	{
		return productIds.get(i);
	}
}
