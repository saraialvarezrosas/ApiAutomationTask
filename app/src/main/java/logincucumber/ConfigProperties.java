/**
 * Copyright (c) 2023 Jala University.
 *
 * This software is the confidential and proprieraty information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University.
 */
package logincucumber;
import org.aeonbits.owner.Config;
/**
 * It is responsible for connecting to the config.properties file for obtaining the variables
 */
@Config.Sources("classpath:config.properties")
public interface ConfigProperties extends Config {
    String username();
    String password();
    String apiUrl();
    String firstName();
    String lastName();
    String email();
    int id();
    String dateJoined();
}