package org.caringbridge.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The base class for all the exceptions in the service platform.
 *
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "0001")
public class CbServiceException extends Exception {

    /**
     * Serial version for the class.
     */
    private static final long serialVersionUID = -3194145754564683372L;

}
