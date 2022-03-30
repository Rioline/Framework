package com.epam.automation.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {

    private static final Logger log = LogManager.getLogger(TestLogger.class.getName());

    public static void writeMessage(String message){
        log.trace(message);
    }

}
