package com.originstamp.client;


import org.apache.log4j.*;

import java.io.IOException;

/**
 * @author Thomas Hepp
 *         Factory class for log4J
 */
class LoggerFactory {


    /**
     * returns an instance of the logger that uses file logging and console logging
     *
     * @param className   defines the tag of the log
     * @param showConsole boolean.
     *                    true: console logging is enabled
     *                    false: console logging is disabled
     * @return
     */
    public static Logger getFileLogger(String className, boolean showConsole) {
        Logger logger = Logger.getLogger(className);

        PatternLayout layout = new PatternLayout("%d{ISO8601} %-5p [%t] %c: %m%n");
        FileAppender fileAppender = null;
        // try to creates the logging file
        try {
            fileAppender = new FileAppender(layout, "logs/originstamp.log", true);
        } catch (IOException e) {
            logger.error(e.getMessage());

        }
        logger.addAppender(fileAppender);
        // console output
        if (showConsole) {
            logger.addAppender(new ConsoleAppender(layout));
        }
        logger.setLevel(Level.ALL);

        return logger;
    }
}