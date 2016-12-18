package then;


import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import controller.ShopController;
import model.product.Product;

import java.util.HashMap;

import static junit.framework.TestCase.assertTrue;

/**
 * Created by louis on 18/12/2016.
 */
public class Then extends Stage<Then>
{
	@ExpectedScenarioState
	private ShopController shopController;
	@ExpectedScenarioState
	private String title;
	@ExpectedScenarioState
	private String id;

	public void correct_info_is_Given(String title, String id)
	{
		assertTrue(shopController.getProductsHashMap().get(id).getProductTitle().equals(title));
	}

	public void correct_random_info_is_given()
	{
		System.out.println("loading ...");
		ShopController tempController = new ShopController();
		tempController.setPersitible("Database");
		tempController.reloadFromPersister();
		HashMap<String, Product> productsHashMap = tempController.getProductsHashMap();
		Product product = productsHashMap.get(id);
		String productTitle = product.getProductTitle();
		assertTrue(productTitle.equals(title));
	}
}
