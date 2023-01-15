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
 * It is responsible for containing the data of the different status code.
 *
 * @author Sarai Alvarez
 * @version 1.0
 */
public enum StatusCode {
    STATUS_CODE_200(200),
    STATUS_CODE_201(201),
    STATUS_CODE_400(400),
    STATUS_CODE_401(401),
    STATUS_CODE_404(404),
    STATUS_CODE_405(405),
    STATUS_CODE_204(204);
    private int statusCode;
    StatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public int statusCode() {
        return statusCode;
    }
}
