package com.originstamp.client;

import org.apache.log4j.Logger;
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
    public void getHashInformation(String pHash) {
        LOGGER.info("requesting hash information for hash");
        return;
    }

    public void getHashInformation(byte[] pBytes) {
        LOGGER.info("requesting hash information for bytes");
        // TODO
    }

    public void getHashesForMail(String pMail, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for mail");
        // TODO
    }

    public void getHashesForDay(Date pDay, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for day");
        // TODO
    }

    public void getHashesForComment(String pComment, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for comment");
        // TODO
    }

    public void getHashesForAPIKey(String pAPIKey, Integer pStartIndex, Integer pEndIndex, Integer pAmount) {
        LOGGER.info("requesting hashes for api key");
        // TODO
    }

    public void storeHashInformation(String pHash, String pComment, String pMail, boolean pTwitter) {
        LOGGER.info("storing hash information");
        // TODO
    }

}
