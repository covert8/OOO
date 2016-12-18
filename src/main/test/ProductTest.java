import com.tngtech.jgiven.junit.ScenarioTest;
import given.Given;
import org.junit.Test;
import then.Then;
import when.When;

/**
 * Created by louis on 18/12/2016.
 */
public class ProductTest extends ScenarioTest<Given, When, Then>
{
	@Test
	public void product_is_registerd_correctly()
	{
		given().a_registerd_product("x", "100");
		when().product_info_is_asked();
		then().correct_info_is_Given("x", "100");
	}

	@Test
	public void save_product_to_database()
	{
		given().a_registerd_product();
		when().product_is_put_in_database();
		then().correct_random_info_is_given();
	}
}
