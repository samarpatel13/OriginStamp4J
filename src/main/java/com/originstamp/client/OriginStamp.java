package com.originstamp.client;

import com.originstamp.client.dto.OriginStampHash;
import com.originstamp.client.dto.OriginStampTableEntity;
import com.originstamp.client.exceptions.InvalidConfigurationException;
import com.originstamp.client.exceptions.InvalidParameterException;
import org.apache.log4j.Logger;
import rx.Observable;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         Main class which is the interface between a program and the API.
 *         As a result of the requests, Observables are returned which are used for the access on the API
 */
public class OriginStamp {
    // logger
    private static final Logger LOGGER = Logger.getLogger(OriginStamp.class);

    /**
     * creates a new instance of the current class and hands over the configuration for the API access
     */
    public OriginStamp(OriginStampConfiguration pOriginStampConfiguration) throws InvalidConfigurationException {
        LOGGER.info("init originstamp main class");

        // init validation model
        RequestValidation requestValidation = new RequestValidation();
        // validate configuration
        requestValidation.verifyConfiguration(pOriginStampConfiguration);

        // validation of the configuration
        this.originStampConfiguration = pOriginStampConfiguration;
    }

    // configuration object
    private OriginStampConfiguration originStampConfiguration;

    /**
     * returns an observable which returns hash information for a given input hash
     *
     * @param pHash input hash in hex representation
     * @return Observable which can be subscribed on to get the results
     * @throws InvalidParameterException an error is thrown when the hash format is invalid
     */
    public Observable<OriginStampHash> getHashInformation(String pHash) throws InvalidParameterException {
        LOGGER.info("requesting hash information for hash");

        // init validation model
        RequestValidation requestValidation = new RequestValidation();
        // validate hash
        boolean isValid = requestValidation.validateHashFormat(pHash);

        // check if parameter is valid
        if (!isValid) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("The hash format is not valid: Please use the HEX representation of SHA-256");
        }

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("creating Observable");

        // returning observable
        return originStampClient.getHashInformation(pHash);
    }

    /**
     * The method returns hash information Observable for a byte array for which the SHA-256 is calculated
     *
     * @param pBytes inputstream
     * @return Observalbe which can be subscribed on to get the results
     * @throws NoSuchAlgorithmException an error is thrown when the hash algorithm (included in Java) was not found
     */
    public Observable<OriginStampHash> getHashInformation(byte[] pBytes) throws NoSuchAlgorithmException {
        LOGGER.info("requesting hash information for bytes");

        LOGGER.info("converting bytes to hash");

        // init hash model
        HashModel hashModel = new HashModel();

        // convert to HEX String
        String hash = hashModel.getSHA256(pBytes);

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("creating Observable");

        // returning observable
        return originStampClient.getHashInformation(hash);
    }

    /**
     * the method creates an Observable for requesting the hashes table by mail
     *
     * @param pMail   filter criteria: email
     * @param pOffset offset: starting index (used for Pagination)
     * @param pAmount number of tuples / records which should be returned
     * @return Observable which can be subscribed on to get the hash table results for the specified email
     * @throws InvalidParameterException The exception is thrown when an input parameter is not valid
     */
    public Observable<OriginStampTableEntity> getHashesForMail(String pMail, Integer pOffset, Integer pAmount) throws InvalidParameterException {
        LOGGER.info("requesting hashes for mail");

        // validating input parameter
        RequestValidation requestValidation = new RequestValidation();
        // validate
        boolean isValid = requestValidation.validateEmailFormat(pMail);

        // check if parameter is valid
        if (!isValid) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("The input parameter [EMAIL] is not valid");
        }

        // verify index parameters
        requestValidation.verifyTableParameters(pOffset, pAmount);

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.MAIL, pMail, pOffset, pAmount);
    }

    /**
     * the method creates an Observable for requesting the hashes table by day
     *
     * @param pDay    filter criteria: Date -> which is converted to a day string in yyyy-MM-dd format
     * @param pOffset offset: starting index (used for Pagination)
     * @param pAmount number of tuples / records which should be returned
     * @return Observable which can be subscribed on to get the hash table results by day
     * @throws InvalidParameterException The exception is thrown when an input parameter is not valid
     */
    public Observable<OriginStampTableEntity> getHashesForDay(Date pDay, Integer pOffset, Integer pAmount) throws InvalidParameterException {
        LOGGER.info("requesting hashes for day");

        // validating input parameter
        RequestValidation requestValidation = new RequestValidation();
        // validate
        boolean isValid = requestValidation.validateDate(pDay);

        // check if parameter is valid
        if (!isValid) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("The input parameter [DATE] is not valid");
        }

        // verify index parameters
        requestValidation.verifyTableParameters(pOffset, pAmount);

        // Create an instance of SimpleDateFormat used for formatting
        // the string representation of date (month/day/year)
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        // formatting the date
        String dayString = df.format(pDay);
        
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.DAY, dayString, pOffset, pAmount);
    }

    /**
     * the method creates an Observable for requesting the hashes table raw
     *
     * @param pOffset offset: starting index (used for Pagination)
     * @param pAmount number of tuples / records which should be returned
     * @return Observable which can be subscribed on to get the hash table results
     * @throws InvalidParameterException The exception is thrown when an input parameter is not valid
     */
    public Observable<OriginStampTableEntity> getHashesForNoFilter(Integer pOffset, Integer pAmount) throws InvalidParameterException {
        LOGGER.info("requesting all hashes");
        // init request validation
        RequestValidation requestValidation = new RequestValidation();
        // verify index parameters
        requestValidation.verifyTableParameters(pOffset, pAmount);
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.UNFILTERED, "", pOffset, pAmount);
    }

    /**
     * the method creates an Observable for requesting the hashes table by comment
     *
     * @param pComment filter criteria: comment -> entered on the hash creation
     * @param pOffset  offset: starting index (used for Pagination)
     * @param pAmount  number of tuples / records which should be returned
     * @return Observable which can be subscribed on to get the hash table results by comment
     * @throws InvalidParameterException The exception is thrown when an input parameter is not valid
     */
    public Observable<OriginStampTableEntity> getHashesForComment(String pComment, Integer pOffset, Integer pAmount) throws InvalidParameterException {
        LOGGER.info("requesting hashes for comment");

        if (pComment == null || pComment.isEmpty()) {
            throw new InvalidParameterException("The input parameter [COMMENT] is not valid");
        }

        // init request validation
        RequestValidation requestValidation = new RequestValidation();
        // verify index parameters
        requestValidation.verifyTableParameters(pOffset, pAmount);

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.COMMENT, pComment, pOffset, pAmount);
    }

    /**
     * the method creates an Observable for requesting the hashes table by api key
     *
     * @param pAPIKey filter criteria: api key -> hashes that are created by a specified api key
     * @param pOffset offset: starting index (used for Pagination)
     * @param pAmount number of tuples / records which should be returned
     * @return Observable which can be subscribed on to get the hash table results by api key
     * @throws InvalidParameterException The exception is thrown when an input parameter is not valid
     */
    public Observable<OriginStampTableEntity> getHashesForAPIKey(String pAPIKey, Integer pOffset, Integer pAmount) throws InvalidParameterException {
        LOGGER.info("requesting hashes for api key");

        // validating input parameter
        RequestValidation requestValidation = new RequestValidation();
        // validate
        boolean isValid = requestValidation.validateApiKeyFormat(pAPIKey);

        // check if parameter is valid
        if (!isValid) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("The input parameter [API KEY] is not valid");
        }

        // verify index parameters
        requestValidation.verifyTableParameters(pOffset, pAmount);

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.API_KEY, pAPIKey, pOffset, pAmount);
    }

    /**
     * the method returns an Observable that is used for stamping a new hash
     *
     * @param pHash    hash value in HEX
     * @param pComment comment what the user defined, not necessary
     * @param pMail    user email address, not necessary
     * @param pTwitter publish hash on twitter
     * @param pBitcoin store hash in the blockchain
     * @return Observable which can be subscribed on to POST the hash data
     * @throws InvalidParameterException The exception is thrown when an input parameter is not valid
     */
    public Observable<OriginStampHash> storeHashInformation(String pHash, String pComment, String pMail, boolean pTwitter, boolean pBitcoin) throws InvalidParameterException {
        LOGGER.info("storing hash information");

        // init validation
        RequestValidation requestValidation = new RequestValidation();

        // validate
        boolean isValid = requestValidation.validateHashFormat(pHash);
        // check if parameter is valid
        if (!isValid) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("The hash format is not valid: Please use the HEX representation of SHA-256");
        }

        // check if timestamping method is selected
        if (!pTwitter && !pBitcoin) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("At least one timestamping service (Twitter / Bitcoin) needs to be selected");
        }

        // evaluating email
        if (pMail != null && !pMail.isEmpty()) {
            // validating email
            isValid = requestValidation.validateEmailFormat(pMail);

            // check if parameter is valid
            if (!isValid) {
                // throw exception because parameter is invalid
                throw new InvalidParameterException("The input parameter [EMAIL] is not valid");
            }
        }

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.storeHashInformation(pHash, pComment, pMail, pTwitter, pBitcoin);
    }

    /**
     * the method returns an Observable that is used for stamping a new hash
     *
     * @param pBytes   inputstream in bytes
     * @param pComment comment what the user defined, not necessary
     * @param pMail    user email address, not necessary
     * @param pTwitter publish hash on twitter
     * @param pBitcoin store hash in the blockchain
     * @return Observable which can be subscribed on to POST the hash data
     * @throws NoSuchAlgorithmException  an error is thrown when the hash algorithm (included in Java) was not found
     * @throws InvalidParameterException The exception is thrown when an input parameter is not valid
     */
    public Observable<OriginStampHash> storeHashInformation(byte[] pBytes, String pComment, String pMail, boolean pTwitter, boolean pBitcoin) throws NoSuchAlgorithmException, InvalidParameterException {
        LOGGER.info("storing hash information");

        LOGGER.info("calculating hash for bytes");
        // init hash model
        HashModel hashModel = new HashModel();
        // calculate SHA 256
        LOGGER.info("calculating SHA-256");
        String sha256 = hashModel.getSHA256(pBytes);

        // init validation
        RequestValidation requestValidation = new RequestValidation();

        // validate
        boolean isValid = requestValidation.validateHashFormat(sha256);
        // check if parameter is valid
        if (!isValid) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("The hash format is not valid: Please use the HEX representation of SHA-256");
        }

        // check if timestamping method is selected
        if (!pTwitter && !pBitcoin) {
            // throw exception because parameter is invalid
            throw new InvalidParameterException("At least one timestamping service (Twitter / Bitcoin) needs to be selected");
        }

        // evaluating email
        if (pMail != null && !pMail.isEmpty()) {
            // validating email
            isValid = requestValidation.validateEmailFormat(pMail);

            // check if parameter is valid
            if (!isValid) {
                // throw exception because parameter is invalid
                throw new InvalidParameterException("The input parameter [EMAIL] is not valid");
            }
        }

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.storeHashInformation(sha256, pComment, pMail, pTwitter, pBitcoin);
    }
}
