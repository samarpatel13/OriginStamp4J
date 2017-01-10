package com.originstamp.client;

import com.originstamp.client.exceptions.InvalidConfigurationException;
import com.originstamp.client.exceptions.InvalidParameterException;
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
     * the method validates the originstamp configuration object
     *
     * @param pOriginStampConfiguration
     * @return true: valid
     * false: invalid
     */
    public boolean verifyConfiguration(OriginStampConfiguration pOriginStampConfiguration) throws InvalidConfigurationException {
        // validating the apikey
        boolean apiKey = this.validateApiKeyFormat(pOriginStampConfiguration.getApiKey());

        // evaluate verification result
        if (!apiKey) {
            // throwing an exception the API key is not valid
            throw new InvalidConfigurationException("Apikey is incorrect. Please generate a valid key on the official page: http://originstamp.com");
        }


        //validating the host
        boolean host = this.validateHost(pOriginStampConfiguration.getHost());

        // evaluate verification result
        if (!host) {
            // throwing an exception the API key is not valid
            throw new InvalidConfigurationException("Host is invalid please check the API host on the official developers section of http://originstamp.com");
        }


        // else
        return true;
    }

    /**
     * the method validates the pagination parameters for the hash table request
     *
     * @param pOffset  Offset: starting index
     * @param pRecords number of tuples
     * @return true: valid; false: invalid;
     * @throws InvalidParameterException an exception is thrown if one of the parameters is invalid
     */
    public boolean verifyTableParameters(Integer pOffset, Integer pRecords) throws InvalidParameterException {
        // check if offset is null
        if (pOffset == null) {
            // is null, throw exception
            throw new InvalidParameterException("the [offset] parameter cannot be null");
        }

        // check if number of records is null
        if (pRecords == null) {
            // is null, throw exception
            throw new InvalidParameterException("the [Number of Records] parameter cannot be null");
        }

        // finally
        return true;
    }

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
        // check if null
        if (pApiKey == null) {
            // is null = invalid
            return false;
        }

        // check if empty
        if (pApiKey.isEmpty()) {
            // is empty = invalid
            return false;
        }

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
        // check if null
        if (pHost == null) {
            // is null = invalid
            return false;
        }

        // check if empty
        if (pHost.isEmpty()) {
            // is empty = invalid
            return false;
        }

        try {
            // try to create new url
            new URL(pHost);
            // successful
            return true;
        } catch (Exception e) {
            // error, host invalid
            return false;
        }
    }

    /**
     * validates if the hash string is in valid hex representation
     *
     * @param pHash hash in string representation
     * @return true: hash is in valid HEX representation
     * false: hash is in invalid representation
     */
    public boolean validateHashFormat(String pHash) {
        // check if null
        if (pHash == null) {
            // is null = invalid
            return false;
        }

        // check if empty
        if (pHash.isEmpty()) {
            // is empty = invalid
            return false;
        }

        // check if hash matches regexp for HEX strings
        if (pHash.matches("^([A-Fa-f0-9]{16,256})")) {
            // is a valid hash in hex representation
            return true;
        } else {
            // is not a valid hex string
            return false;
        }
    }

    /**
     * validates the given input string if it is a valid email address
     *
     * @param pMail email
     * @return true: email format is correct
     * false: email format is incorrect
     */
    public boolean validateEmailFormat(String pMail) {
        // check if null
        if (pMail == null) {
            // is null = invalid
            return false;
        }

        // check if empty
        if (pMail.isEmpty()) {
            // is empty = invalid
            return false;
        }

        // defining regexp of mail
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        // check if given string matches email pattern
        if (pMail.matches(EMAIL_PATTERN)) {
            // is valid mail
            return true;
        } else {
            return false;
        }
    }

    /**
     * validates the input date if it is not null
     *
     * @param pDate any date
     * @return true: date is valid
     * false: date is invalid
     */
    public boolean validateDate(Date pDate) {
        if (pDate == null) {
            return false;
        } else {
            return true;
        }
    }
}
