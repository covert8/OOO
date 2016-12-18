package given;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import controller.ShopController;

import java.util.Random;

/**
 * Created by louis on 18/12/2016.
 */
public class Given extends Stage<Given>
{
	@ProvidedScenarioState
	private ShopController shopController;
	@ProvidedScenarioState
	private String id;
	@ProvidedScenarioState
	private String title;

	public Given a_registerd_product()
	{
		Random random = new Random();
		String title = String.valueOf(random.nextInt());
		title += String.valueOf(random.nextInt());
		String id = String.valueOf(random.nextInt());
		return a_registerd_product(title, id);
	}

	public Given a_registerd_product(String title, String id)
	{
		this.title = title;
		this.id = id;
		shopController = new ShopController();
		shopController.addProduct(title, id, "G");
		return self();
	}

}
