package com.sam.utils;

import org.apache.logging.log4j.LogManager;

public class Logger {
    static org.apache.logging.log4j.Logger logger;

    static{
        logger = LogManager.getLogger();
    }

    public static void info(String message){
        logger.info(message);
    }


}
