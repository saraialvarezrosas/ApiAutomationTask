/**
 * Copyright (c) 2023 Jala University.
 *
 * This software is the confidential and proprieraty information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University.
 */

 package logincucumber;
import org.apache.log4j.Logger;

/**
 * This class is responsible for initialice the Logger and associate it with the
 * properties file.
 *
 * @author Jose Romay
 * @version 1.0
 */
public class LoggerApi {
    private static LoggerApi instance;
    private static Logger log = Logger.getLogger(LoggerApi.class.getName());
    private LoggerApi() {
        // Private constructor to prevent instantiation
    }
    public static LoggerApi getInstance() {
        if (instance == null) {
            instance = new LoggerApi();
        }
        return instance;
    }
    public void debug(String message) {
        log.debug(message);
    }
    public void info(String message) {
        log.info(message);
    }
    public void warn(String message) {
        log.warn(message);
    }
    public void error(String message) {
        log.error(message);
    }
}