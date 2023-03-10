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

public class LoginBasicSteps {

    private static ConfigProperties confProp;
    private static  Response response ;
    private static User body;
    @Given("Get the URL of the login")
    public void user_on_login_page() {
        System.out.println("corriendo login basic steps!!!!!!");
        confProp = ConfigFactory.create(ConfigProperties.class);
        body = User.builder()
                .username(confProp.username())
                .password(confProp.password()).build();
    }
    @When("the user enters the correct username and password")
    public void user_enters_credentials() {
        System.out.println("the user enters the correct username and password!!!");
        ApiManager apiManager = new ApiManager();
        response = apiManager
                .postBasic(EndPoints.BASIC.api(), body);
    }
    @Then("the status code should be OK")
    public void user_on_home_page() {
        System.out.println("the status code should be OK!!!");
        assertEquals(StatusCode.STATUS_CODE_200.statusCode(), response.getStatusCode());
    }
}