package com.originstamp.client.exceptions;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         an individual exception which is thrown if the parameters are not correct
 */
public class InvalidParameterException extends Exception {
    public InvalidParameterException() {
        super();
    }

    public InvalidParameterException(String message) {
        super(message);
    }

    public InvalidParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidParameterException(Throwable cause) {
        super(cause);
    }
}
