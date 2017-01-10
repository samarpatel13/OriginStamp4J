package com.originstamp.client;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         the class calculates the hash of a given byte array input. The hash is represented by a HEX string with the length of 64.
 */
class HashModel {
    // logger
    private static final Logger LOGGER = LoggerFactory.getFileLogger(HashModel.class.getSimpleName(), true);

    /**
     * creates a new instance of the hash model class
     */
    public HashModel() {
        LOGGER.info("init hash model");
    }

    /**
     * calculates the SHA256 hash from a byte array and returns it in HEX
     *
     * @param pBytes
     * @return
     */
    public String getSHA256(byte[] pBytes) throws NoSuchAlgorithmException {
        LOGGER.info("converting bytes to SHA-256");
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(pBytes);
        byte[] digest = sha.digest();

        LOGGER.info("converting SHA-256 to HEX representation");
        // return hex string
        return convertToHex(digest);
    }

    /**
     * converts a byte array to its hex string representation
     *
     * @param pBytes
     * @return
     */
    private String convertToHex(byte[] pBytes) {
        // init string buffer
        StringBuffer hexString = new StringBuffer();

        // for each byte
        for (int i = 0; i < pBytes.length; i++) {
            String hex = Integer.toHexString(0xff & pBytes[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }

        // return the string
        return hexString.toString();
    }
}
