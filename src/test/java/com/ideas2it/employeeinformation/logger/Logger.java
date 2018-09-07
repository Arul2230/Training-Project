package com.ideas2it.employeeinformation.logger;

import org.apache.log4j.xml.DOMConfigurator;

import com.ideas2it.employeeinformation.commons.constants.Constants;

/**
 * Logger is the Custom Logger class is used to log all the error messages
 * occurs in the Application.This class uses the log4j logger to log the error
 * message.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class Logger {

    private static org.apache.log4j.Logger logger = null;

    static {	
        logger = org.apache.log4j.Logger.getLogger(Logger.class);
        DOMConfigurator.configure(Constants.LOG_PROPERTY_FILE);
    }

    public static void debug(Object message) {
        logger.debug(message);
    }

    public static void warn(Object message) {
        logger.warn(message);
    }

    public static void info(Object message) {
        logger.info(message);
    }

    public static void error(Object message) {
        logger.error(message);
    }

    public static void fatal(Object message) {
        logger.fatal(message);
    }
}
