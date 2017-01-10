package com.originstamp.client;

import org.apache.log4j.Logger;

/**
 * Created by Thomas on 10.01.17.
 *
 * @author Thomas Hepp
 *         The class deals with the validation of the configuration file. It checks whether the configuration is valid or not.
 *         This includes checks of the URL format of the host address and the API Key
 */
class ConfigurationValidation {
    // logger
    private static final Logger LOGGER = LoggerFactory.getFileLogger(ConfigurationValidation.class.getSimpleName(), true);


    protected ConfigurationValidation() {
        LOGGER.info("init configuration validation");
    }
}
