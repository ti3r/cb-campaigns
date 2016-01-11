package org.caringbridge.services.exceptions;

import org.caringbridge.services.CbServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * The Exception thrown when a goal is not found.
 *
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "0002")
public class CbGoalNotFoundException extends CbServiceException {

    /**
     * Serial version for the class.
     *
     */
    private static final long serialVersionUID = 8934518773486428163L;

}
