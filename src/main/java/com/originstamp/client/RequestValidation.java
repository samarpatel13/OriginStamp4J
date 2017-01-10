package com.originstamp.client;

import org.apache.log4j.Logger;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         the class deals with the validation of the request parameters. if valid a boolean = true is returned otherwise false
 */
class RequestValidation {
    // logger
    private static final Logger LOGGER = LoggerFactory.getFileLogger(RequestValidation.class.getSimpleName(), true);

    /**
     * constructor which creates a new instance of the current class
     */
    public RequestValidation() {
        LOGGER.info("init request validation");
    }
}
