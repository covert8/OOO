package model.product;

public class CD extends Product
{
	public CD(String productTitles, String productIds) {
		super(productTitles, productIds);
	}

	@Override
	public String getProductType() {
		return "CD";
	}
}
