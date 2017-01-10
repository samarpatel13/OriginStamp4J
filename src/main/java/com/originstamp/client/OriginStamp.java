package com.originstamp.client;

import com.originstamp.client.dto.OriginStampHash;
import com.originstamp.client.dto.OriginStampTableEntity;
import com.originstamp.client.exceptions.InvalidConfigurationException;
import org.apache.log4j.Logger;
import rx.Observable;

import java.security.NoSuchAlgorithmException;
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
    private static final Logger LOGGER = LoggerFactory.getFileLogger(OriginStamp.class.getSimpleName(), true);

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
     * requesting the hash information for a specified hash
     *
     * @param pHash a hash in HEX representation
     */
    public Observable<OriginStampHash> getHashInformation(String pHash) {
        LOGGER.info("requesting hash information for hash");
        // TODO validating input

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("creating Observable");

        // returning observable
        return originStampClient.getHashInformation(pHash);
    }

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

    public Observable<OriginStampTableEntity> getHashesForMail(String pMail, Integer pOffset, Integer pAmount) {
        LOGGER.info("requesting hashes for mail");

        // TODO validating input

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.MAIL, pMail, pOffset, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForDay(Date pDay, Integer pOffset, Integer pAmount) {
        LOGGER.info("requesting hashes for day");

        // TODO validating input
        String dayString = "";
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.DAY, dayString, pOffset, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForNoFilter(Integer pOffset, Integer pAmount) {
        LOGGER.info("requesting hashes for day");
        // TODO validating input
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.UNFILTERED, "", pOffset, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForComment(String pComment, Integer pOffset, Integer pAmount) {
        LOGGER.info("requesting hashes for comment");
        // TODO validating input
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.COMMENT, pComment, pOffset, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForAPIKey(String pAPIKey, Integer pOffset, Integer pAmount) {
        LOGGER.info("requesting hashes for api key");
        // TODO validating input
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.API_KEY, pAPIKey, pOffset, pAmount);
    }

    public Observable<OriginStampHash> storeHashInformation(String pHash, String pComment, String pMail, boolean pTwitter, boolean pBitcoin) {
        LOGGER.info("storing hash information");

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        LOGGER.info("create and return Observable");

        // returning Observable
        return originStampClient.storeHashInformation(pHash, pComment, pMail, pTwitter, pBitcoin);
    }
}
