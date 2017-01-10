package com.originstamp.client;

/**
 * @author Thomas Hepp
 *         The class is a data-transfer object that contains the configuration for API access for the main application
 */
public class OriginStampConfiguration {
    private String host;
    private String apiKey;

    /**
     * getter method which returns the complete host name
     *
     * @return
     */
    public String getHost() {
        return host;
    }

    /**
     * setter method which
     * @param host
     */
    public void setHost(String host) {
        this.host = host;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
