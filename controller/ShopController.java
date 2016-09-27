package controller;

import model.ShopModel;

/**
 * Created by louis on 21/09/2016.
 */

public class ShopController {
	private ShopModel model = new ShopModel();

	public double getPrice(int productidx, int days) {
		double price = 0;
		
		if(model.getProductIds(productidx).equals("M")){
			price = 5;
			int daysLeft = days - 3;
			if (daysLeft > 0) {
				price += (daysLeft * 2);
			}
		} else if(model.getProductIds(productidx) == "G"){
			price = days * 3;
		}
		return price;
	}	

}
