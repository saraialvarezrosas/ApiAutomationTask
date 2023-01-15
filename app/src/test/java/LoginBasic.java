/**
 * Copyright (c) 2023 Jala University.
 *
 * This software is the confidential and proprieraty information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University.
 */
//package incrediboys;
import logincucumber.ApiManager;
import logincucumber.ConfigProperties;
import logincucumber.LoggerApi;
import logincucumber.TestTags;
import logincucumber.entities.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.io.File;
import logincucumber.EndPoints;
import logincucumber.StatusCode;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for basic login endpoints for the API.
 * https://test-api.k6.io/auth/basic/login/
 *
 * @author Sarai Alvarez
 * @version 1.0
 */
public class LoginBasic {
    private static ConfigProperties confProp;
    private static Logger log = Logger.getLogger(LoggerApi.class.getName());

    /**
     * Verify that the user can access to the application with username or password valid. AT-19
     */
    @Test
    @Tag(TestTags.POSITIVE_TEST)
    public void verifyloginWithValidData() {
        log.info("Verify that the user can access to the application with username or password valid. AT-19");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
                .username(confProp.username())
                .password(confProp.password()).build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
                .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_200.statusCode(), response.getStatusCode());
    }

    /**
     * Verify the format of the json message if the user logs in with valid data AT-18
     */
    @Test
    @Tag(TestTags.POSITIVE_TEST)
    public void loginTestVerifyFormatOfTheJsonWithValidData() {
        log.info("Verify the format of the json message if the user logs in with valid data AT-18");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
                .username(confProp.username())
                .password(confProp.password()).build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager.postBasic(EndPoints.BASIC.api(), body);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_login_basic.json")));
    }

    /**
     * "Verify the fields the json message, if the user log in with valid data AT-17"
     */
    @Test
    @Tag(TestTags.POSITIVE_TEST)
    public void verifyContentOfTheJsonWithValidData() {
        log.info("Verify the fields the json message, if the user log in with valid data AT-17");

        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
                .username(confProp.username())
                .password(confProp.password()).build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager.postBasic(EndPoints.BASIC.api(), body);
        log.info("THE OBTAINED JSON MESSAGE IS : "  +  response.jsonPath());
        assertEquals(response.jsonPath().getString("username"), "incrediboys");
        assertEquals(response.jsonPath().getString("last_name"), "boys");
        assertEquals(response.jsonPath().getString("first_name"), "incredi");
        assertEquals(response.jsonPath().getString("email"), "incrediboys@jala.university");
        assertEquals(response.jsonPath().getString("date_joined"), "2023-01-09T19:24:57.856102Z");
    }

    /**
     * Verify that the API returns a json if the user enter only the username field.****ADD SUBTASKS!!!***
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonErrorMessageIfEnterOnlyUsername() {
        log.info("Verify that the API returns a json if the user enter only the username field.****ADD SUBTASKS!!!***");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username(confProp.username())
            .password(null).build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
            .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_password_null.json")));
    }

    /**
     * Verify that the API returns a json if the user enter only the password field.****ADD SUBTASKS!!!
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonErrorMessageIfEnterOnlyPassword() {
        log.info("Verify that the API returns a json if the user enter only the password field.****ADD SUBTASKS!!!***");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username(null)
            .password(confProp.password()).build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
            .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_username_null.json")));
    }

    /**
     * Verify the json error message, if the username is invalid AT-16
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonErrorMessageWithInvalidUsername() {
        log.info("Verify the json error message, if the username is invalid AT-16");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username("incrediboysssss") //invalid data
            .password("123456").build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
            .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_non_field_errors.json")));
    }

    /**
     * Verify the json error message, if the password is invalid AT-42
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonErrorMessageWithInvalidPassword() {
        log.info("Verify the json error message, if the password is invalid AT-42");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username("incrediboys")
            .password("12345666666").build(); //invalid data
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
            .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_non_field_errors.json")));
    }

    /**
     * Verify the json message, if the password contains spaces AT-43
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonMessageIfPasswordContainsSpaces() {
        log.info("Verify the json message, if the password contains spaces AT-43");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username("incrediboys")
            .password("12   34   56").build(); //invalid data
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
            .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_non_field_errors.json")));
    }

    /**
     * Verify the json message, if the username contains spaces AT-44
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonMessageIfUsernameContainsSpaces() {
        log.info("Verify the json message, if the username contains spaces AT-44");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username("in  cre  dib  oys")  //invalid data
            .password("123456").build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
            .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_non_field_errors.json")));
    }

    /**
     * Verify the json message, if the password contains only spaces AT-45
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonMessageIfPasswordIsOnlySpaces() {
        log.info("Verify the json message, if the password contains only spaces AT-45");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username("incrediboys")
            .password("      ").build(); //invalid data
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
            .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_password_blank.json")));
    }

    /**
     * Verify the json message, if the username contains only spaces AT-46
     */
    @Test
    @Tag(TestTags.NEGATIVE_TEST)
    public void verifyJsonMessageIfUsernameIsOnlySpaces() {
        log.info(" Verify the json message, if the username contains only spaces AT-46");
        confProp = ConfigFactory.create(ConfigProperties.class);
        User body = User.builder()
            .username("          ")    //invalid data
            .password("123456").build();
        ApiManager apiManager = new ApiManager();
        Response response = apiManager
                .postBasic(EndPoints.BASIC.api(), body);
        assertEquals(StatusCode.STATUS_CODE_400.statusCode(), response.getStatusCode());
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/schema_username_blank.json")));
    }
}
