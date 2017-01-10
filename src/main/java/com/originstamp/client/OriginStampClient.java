package com.originstamp.client;

import com.originstamp.client.dto.OriginStampHash;
import com.originstamp.client.dto.OriginStampTableEntity;
import com.originstamp.client.request.*;
import org.apache.log4j.Logger;
import org.glassfish.jersey.client.rx.rxjava.RxObservable;
import rx.Observable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by Thomas on 10.01.17.
 */
class OriginStampClient {
    // static values
    private static final String URI_HASH_VALUE = "{hash_value}";
    private static final String URI_TABLE = "table";

    // logger
    private static final Logger LOGGER = LoggerFactory.getFileLogger(OriginStampClient.class.getSimpleName(), true);
    // member variable
    private OriginStampConfiguration originStampConfiguration;

    /**
     * constructor which creates a new instance of the originstamp client. Besides, the configuration is hand over to this class and finally the headers for the requests are created
     *
     * @param pOriginStampConfiguration
     */
    public OriginStampClient(OriginStampConfiguration pOriginStampConfiguration) {
        LOGGER.info("init originstamp client");

        // hand over the api configuration
        this.originStampConfiguration = pOriginStampConfiguration;

        // creating the header
        this.createHeader();
    }

    /**
     * the method creates a header from the configuration of the originstamp service. The header is used for the request and contains the api key for authorization.
     */
    private void createHeader() {
        LOGGER.info("creating header");

        // init new header
        this.header = new MultivaluedHashMap<>();

        // add consuming json
        this.header.add("Content-Type", "application/json");
        this.header.add("Accept", "application/json");

        // setting the authorization key
        this.header.add("Authorization", this.originStampConfiguration.getApiKey());

        LOGGER.info("header created");
    }

    // member variable creating new client
    private Client restClient = ClientBuilder.newClient();
    // header map
    private MultivaluedMap<String, Object> header;


    /**
     * returns an observable that requests the hash information from the API
     *
     * @param pHash
     * @return
     */
    public Observable<OriginStampHash> getHashInformation(String pHash) {
        LOGGER.info("creating Observable from configuration and parameters");

        // building observable and return
        return RxObservable.from(this.restClient)
                .target(this.originStampConfiguration.getHost() + URI_HASH_VALUE)
                .resolveTemplate("hash_value", pHash)
                .request()
                .headers(this.header)
                .rx()
                .get(new GenericType<OriginStampHash>() {
                });
    }

    /**
     * returns an observable that requests the hash table information from the API based on the parameters
     *
     * @return
     */
    public Observable<OriginStampTableEntity> getHashTableInformation(HashTableType pHashTableType, String pParameter, Integer pOffset, Integer pAmount) {
        LOGGER.info("creating Observable for Hash Table Information");

        // fail save
        if (pParameter == null || pParameter.isEmpty() || pParameter.matches("")) {
            pHashTableType = HashTableType.UNFILTERED;
        }

        // init entity
        Entity body = Entity.json("");

        // evaluating parameters
        switch (pHashTableType) {
            case MAIL: {
                // creating body
                RequestBodyTableMail requestBody = new RequestBodyTableMail();
                // setting the parameters
                requestBody.setEmail(pParameter);
                requestBody.setOffset(pOffset);
                requestBody.setRecords(pAmount);
                // creating entity
                body = Entity.json(requestBody);
                break;
            }
            case COMMENT: {
                // creating body
                RequestBodyTableComment requestBody = new RequestBodyTableComment();
                // setting the parameters
                requestBody.setComment(pParameter);
                requestBody.setOffset(pOffset);
                requestBody.setRecords(pAmount);
                // creating entity
                body = Entity.json(requestBody);

                break;
            }
            case UNFILTERED: {
                // creating body
                RequestBodyTableAll requestBody = new RequestBodyTableAll();
                // setting the parameters
                requestBody.setOffset(pOffset);
                requestBody.setRecords(pAmount);
                // creating entity
                body = Entity.json(requestBody);
                break;
            }
            case DAY: {
                // creating body
                RequestBodyTableDay requestBody = new RequestBodyTableDay();
                // setting the parameters
                requestBody.setDate_created(pParameter);
                requestBody.setOffset(pOffset);
                requestBody.setRecords(pAmount);
                // creating entity
                body = Entity.json(requestBody);
                break;
            }
            case API_KEY: {
                // creating body
                RequestBodyTableApiKey requestBody = new RequestBodyTableApiKey();
                // setting the parameters
                requestBody.setApi_key(pParameter);
                requestBody.setOffset(pOffset);
                requestBody.setRecords(pAmount);
                // creating entity
                body = Entity.json(requestBody);
                break;
            }
        }

        // building observable and return
        return RxObservable.from(this.restClient)
                .target(this.originStampConfiguration.getHost() + URI_TABLE)
                .request()
                .headers(this.header)
                .rx()
                .post(body, new GenericType<OriginStampTableEntity>() {
                });
    }

    /**
     * enum that defines the type of filtering of the hash table
     */
    enum HashTableType {
        MAIL,
        COMMENT,
        UNFILTERED,
        DAY,
        API_KEY
    }

}
