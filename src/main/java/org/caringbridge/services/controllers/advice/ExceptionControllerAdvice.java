package org.caringbridge.services.controllers.advice;

import java.util.Locale;

import org.caringbridge.services.CbServiceException;
import org.caringbridge.services.rep.ExceptionMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
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

    @Autowired
    private ResourceBundleMessageSource messageSource;

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
	System.out.println("The ResponseStatus is: " + stat.toString());
	String msg = "Unknown Error. Please try again later";
	HttpStatus code = HttpStatus.INTERNAL_SERVER_ERROR;;
	if (stat != null) {
	    code = stat.code();
	    msg = stat.reason();
	}
	Locale en = new Locale("en");
	String errorMsg = messageSource.getMessage(msg, null, en);
	ExceptionMessage res = new ExceptionMessage(code.value(), errorMsg);
	return ResponseEntity.status(code).contentType(MediaType.APPLICATION_JSON).body(res);
    }
}
