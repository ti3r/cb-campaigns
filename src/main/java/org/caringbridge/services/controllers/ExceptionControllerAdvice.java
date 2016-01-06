package org.caringbridge.services.controllers;

import org.caringbridge.services.CbServiceException;
import org.caringbridge.services.rep.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice class that will handle the exceptions in the application
 * and return the appropriate json representation for the exception.
 * 
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

    /**
     * Exception Handler method to convert all the exceptions in the application
     * that extend from CbServiceException and convert them to a clear json
     * representation with the status code, error code and message specified in
     * the @ResponseStatus annotation associated with the exception.
     * 
     * @param ex
     *            The CbServiceException exception thrown in the system
     * @return ResponseEntity<String> with the json content representing the
     *         exception
     */
    @ExceptionHandler(value = CbServiceException.class)
    public final ResponseEntity<ExceptionMessage> handleExceptions(final CbServiceException ex) {
	// Return the status code from the exception
	ResponseStatus stat = ex.getClass().getAnnotation(ResponseStatus.class);
	String msg = "Unknown Error. Please try again later";
	HttpStatus code = null;
	if (stat == null) {
	    code = HttpStatus.INTERNAL_SERVER_ERROR;
	} else {
	    code = stat.code();
	    msg = stat.reason();
	}
	ExceptionMessage res = new ExceptionMessage(1, msg);
	return ResponseEntity.status(code).contentType(MediaType.APPLICATION_JSON).body(res);
    }

}
