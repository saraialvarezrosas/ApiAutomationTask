package steps_definitions;
import logincucumber.ApiManager;
import logincucumber.ConfigProperties;
import logincucumber.EndPoints;
import logincucumber.StatusCode;
import logincucumber.entities.User;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.aeonbits.owner.ConfigFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
public class LoginBasicOutline {
    private static ConfigProperties confProp;
    private static  Response response ;
    private static User body;
    @Given("Get the URL of the login with scenario Outline")
    public void get_the_url_of_the_login_with_scenario_outline() {
        System.out.println("login basic steps Outline!!!");
        confProp = ConfigFactory.create(ConfigProperties.class);
    }
    @When("the user enters the correct {string} and {string} Outline")
    public void the_user_enters_the_correct_incrediboys_and(String username, String password) {
        System.out.println("the user enters the correct username and password Outline!!!");
        body = User.builder()
                .username(username)
                .password(password).build();
        ApiManager apiManager = new ApiManager();
        response = apiManager
                .postBasic(EndPoints.BASIC.api(), body);
    }
    @Then("the status code should be OK Outline")
    public void user_on_home_page() {
        System.out.println("The status code should be OK Outline!!!");
        assertEquals(StatusCode.STATUS_CODE_200.statusCode(), response.getStatusCode());

    }
}
