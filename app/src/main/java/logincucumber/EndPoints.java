/**
 * Copyright (c) 2023 Jala University.
 *
 * This software is the confidential and proprieraty information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University.
 */
package logincucumber;
/**
 * This class is responsible for containing the data of the different endpoints.
 *
 * @author Sarai Alvarez && Jose Romay
 * @version 1.0
 */
public enum EndPoints {
    PUBLIC_CROCODILES("/public/crocodiles/"),
    REGISTER("/user/register/"),
    LOGIN("/auth/cookie/login/"),
    LOGOUT("/auth/cookie/logout/"),
    BASIC("/auth/basic/login/"),
    TOKEN("/auth/token/login/"),
    PRIVATE("/my/crocodiles/");
    private String api;
    /**
     * @param api Receives the parameter to be returned from the enum data
     */
    EndPoints(String api) {
        this.api = api;
    }
    /**
     * @return Returns the value of the requested data
     */
    public String api() {
        return api;
    }
}
