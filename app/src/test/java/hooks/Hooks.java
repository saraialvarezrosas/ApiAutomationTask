package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
    public void beforeScenario(){
        System.out.println("Verify that the user can access to the application with username or password valid. AT-19");
    }	
	
	@After
    public void afterScenario(){
        System.out.println("Login basic executed");
    }
}