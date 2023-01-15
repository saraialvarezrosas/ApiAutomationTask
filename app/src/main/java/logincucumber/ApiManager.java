/**
 * Copyright (c) 2023 Jala University.
 *
 * This software is the confidential and proprieraty information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University.
 */
package logincucumber;
import logincucumber.entities.Entity;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
/**
 * This interface is in charge of performing
 * the owner configuration with the Properties files.
 *
 * @author Jose Romay
 * @version 1.0
 */
public class ApiManager {
    private static ConfigProperties confProp;
    /**
     *This class is responsible for managing the different types of requests.
     */
    public ApiManager() {
        confProp = ConfigFactory.create(ConfigProperties.class);
        RestAssured.baseURI = confProp.apiUrl();
    }
    /**
     * @param endpoint Receives the address of the endpoint where the request will be made.
     * @param id Receives the id of the element to be pointed to in the request
     * @param body Receives the body of the json to be sent via the request
     * @param username Receives the username to be authenticated at the endpoint
     * @param password Receives the user password to be authenticated at the endpoint
     * @return Returns the response to the request made
     */
    public Response put(String endpoint, String id,
            Entity body, String username, String password) {
        return RestAssured.given().auth().basic(username, password)
                .contentType(ContentType.JSON).body(body)
                .put(endpoint + id + "/");
    }
    /**
     * @param endpoint Receives the address of the endpoint where the request will be made.
     * @return Returns the response to the request made
     */
    public Response get(String endpoint) {
        return RestAssured.given().get(endpoint);
    }
    public Response get(String endpoint, String username, String password) {
        return RestAssured.given().auth().basic(username, password)
                .get(endpoint);
    }
    /**
     * @param endpoint Receives the address of the endpoint where the request will be made.
     * @param id Receives the id of the element to be pointed to in the request
     * @return Returns the response to the request made
     */
    public Response get(String endpoint, String id) {
        return RestAssured.given().get(endpoint + id + "/");
    }

    /**
     * @param endpoint Receives the address of the endpoint where the request will be made.
     * @param username Receives the username to be authenticated at the endpoint
     * @param password Receives the user password to be authenticated at the endpoint
     * @return Returns the response to the request made
     */

    public Response get(String endpoint, String username, String password, String id) {
        return RestAssured.given().auth().basic(username, password).get(endpoint + id + "/");
    }
    /**
     * @param endpoint Receives the address of the endpoint where the request will be made.
     * @param body Receives the body of the json to be sent via the request
     * @param username Receives the username to be authenticated at the endpoint
     * @param password Receives the user password to be authenticated at the endpoint
     * @return Returns the response to the request made
     */
    public Response postToken(String endpoint, Entity body, String username, String password) {
        return RestAssured.given()
                .auth().basic(username, password)
                .contentType(ContentType.JSON).body(body)
                .post(endpoint);
    }
    /**
     * @param endpoint Receives the address of the endpoint where the request will be made
     * @param body Receives the body of the json to be sent via the request
     * @return Returns the response to the request made
     */
    public Response postBasic(String endpoint, Entity body) {
        return RestAssured.given()
                .contentType(ContentType.JSON).body(body)
                .post(endpoint);
    }
    /**
     * @param endpoint Receives the address of the endpoint where the request will be made
     * @param id Receives the id of the element to be pointed to in the request
     * @param body Receives the body of the json to be sent via the request
     * @param username Receives the username to be authenticated at the endpoint
     * @param password Receives the user password to be authenticated at the endpoint
     * @return Returns the response to the request made
     */
    public Response patch(String endpoint, String id,
            Entity body, String username, String password) {
        return RestAssured.given().auth().basic(username, password)
                .contentType(ContentType.JSON).body(body)
                .patch(endpoint + id + "/");
    }
    /**
     * @param endpoint Receives the address of the endpoint where the request will be made
     * @param id Receives the id of the element to be pointed to in the request
     * @param username Receives the username to be authenticated at the endpoint
     * @param password Receives the user password to be authenticated at the endpoint
     * @return Returns the response to the request made
     */
    public Response delete(String endpoint, String id, String username, String password) {

        return RestAssured.given().auth().basic(username, password).delete(endpoint + id
                + "/");
    }
}
