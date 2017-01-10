package com.originstamp.client;

import org.apache.log4j.Logger;

import java.net.URL;
import java.util.Date;
import java.util.UUID;

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

    /**
     * tries to convert the api key to a UUID. If successful, the api key seems to be valid
     *
     * @param pApiKey uuid in string representation
     * @return true: api key format is valid
     * false: api key format is not valid
     */
    public boolean validateApiKeyFormat(String pApiKey) {
        try {
            // try to convert api key to UUID
            UUID apikey = UUID.fromString(pApiKey);
            // successful
            return true;
        } catch (Exception e) {
            // error
            return false;
        }
    }

    /**
     * validates the host url
     *
     * @param pHost address of the API backend
     * @return true: host address is valid
     * false: host address is invalid
     */
    public boolean validateHost(String pHost) {
        try {
            new URL(pHost);
            // successful
            return true;
        } catch (Exception e) {
            // error, host invalid
            return false;
        }
    }

    public void validateHashFormat(String pHash) {
        // TODO
    }

    public void validateEmailFormat(String pMail) {
        //TODO
    }

    public void validateDate(Date pDate) {
        // TODO
    }
}
