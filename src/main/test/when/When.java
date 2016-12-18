package when;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import controller.ShopController;

/**
 * Created by louis on 18/12/2016.
 */
public class When extends Stage<When>
{
	@ExpectedScenarioState
	private ShopController shopController;

	public When product_info_is_asked()
	{
		return self();
	}

	public When product_is_put_in_database()
	{
		shopController.setPersitible("Database");
		shopController.saveToPersister();
		return self();
	}
}
