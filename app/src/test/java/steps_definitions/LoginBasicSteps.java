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
    //private static Logger log = Logger.getLogger(LoggerApi.class.getName());
    
    //@Given("Get the URL of the login")
    @Given("^Get the URL of the login$")
    public void user_on_login_page() {
        System.out.println("corriendo login basic steps!!!!!!");
        //log.info("Verify that the user can access to the application with username or password valid. AT-19");
        confProp = ConfigFactory.create(ConfigProperties.class);
        body = User.builder()
                .username(confProp.username())
                .password(confProp.password()).build();
        //.password(confProp.password()).build();
        // code to navigate to the login page
    }
    //@When("the user enters the correct <username> and <password>")
    @When("the user enters the correct username and password")
    public void user_enters_credentials() {
        ApiManager apiManager = new ApiManager();
        response = apiManager
                .postBasic(EndPoints.BASIC.api(), body);
        // code to enter the correct username and password
    }
    @Then("the status code should be OK")
    public void user_on_home_page() {
        assertEquals(StatusCode.STATUS_CODE_200.statusCode(), 200);
        // code to verify that the user is taken to the home page
    }
}