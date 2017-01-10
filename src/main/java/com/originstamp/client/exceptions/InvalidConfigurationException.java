package com.originstamp.client.exceptions;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         an individual exception which is thrown if the configuration is not correct
 */
public class InvalidConfigurationException extends Exception {
    public InvalidConfigurationException() {
        super();
    }

    public InvalidConfigurationException(String message) {
        super(message);
    }

    public InvalidConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidConfigurationException(Throwable cause) {
        super(cause);
    }
}
