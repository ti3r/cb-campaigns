package org.caringbridge.services.exceptions;

import org.caringbridge.services.CbServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * The Exception thrown when a person is not found.
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "0003")
public class CbPersonNotFoundException extends CbServiceException {

    /**
     * Serial version for the class.
     *
     */
    private static final long serialVersionUID = 7665232843854763399L;

}
