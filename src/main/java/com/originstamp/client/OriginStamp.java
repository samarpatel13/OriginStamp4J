package com.originstamp.client;

import com.originstamp.client.dto.OriginStampHash;
import com.originstamp.client.dto.OriginStampTableEntity;
import org.apache.log4j.Logger;
import rx.Observable;

import java.util.Date;

/**
 * Created by Thomas on 10.01.17.
 */
public class OriginStamp {
    // logger
    private static final Logger LOGGER = LoggerFactory.getFileLogger(OriginStamp.class.getSimpleName(), true);

    /**
     * creates a new instance of the current class and hands over the configuration for the API access
     */
    public OriginStamp(OriginStampConfiguration pOriginStampConfiguration) {
        LOGGER.info("init originstamp main class");
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

    public void getHashInformation(byte[] pBytes) {
        LOGGER.info("requesting hash information for bytes");

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);
        // TODO converting
    }

    public Observable<OriginStampTableEntity> getHashesForMail(String pMail, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for mail");

        // TODO validating input

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);

        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.MAIL, pMail, pStartIndex, pEndIndex, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForDay(Date pDay, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for day");

        // TODO validating input
        String dayString = "";
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);
        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.DAY, dayString, pStartIndex, pEndIndex, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForNoFilter(Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for day");
        // TODO validating input
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);
        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.UNFILTERED, "", pStartIndex, pEndIndex, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForComment(String pComment, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for comment");
        // TODO validating input
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);
        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.COMMENT, pComment, pStartIndex, pEndIndex, pAmount);
    }

    public Observable<OriginStampTableEntity> getHashesForAPIKey(String pAPIKey, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for api key");
        // TODO validating input
        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);
        // returning Observable
        return originStampClient.getHashTableInformation(OriginStampClient.HashTableType.API_KEY, pAPIKey, pStartIndex, pEndIndex, pAmount);
    }

    public void storeHashInformation(String pHash, String pComment, String pMail, boolean pTwitter) {
        LOGGER.info("storing hash information");

        // init rest client
        OriginStampClient originStampClient = new OriginStampClient(this.originStampConfiguration);
        // TODO
    }

}
