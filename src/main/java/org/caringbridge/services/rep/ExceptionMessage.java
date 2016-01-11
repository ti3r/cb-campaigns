package org.caringbridge.services.rep;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Representation object for the messages that will be serialized by the
 * exception handlers.
 *
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
public class ExceptionMessage {

    /**
     * The error code for the exception in order to find it in the exception
     * codes catalog.
     */
    @JsonProperty(value = "error_code")
    private Integer errorCode;

    /**
     * The message that will be displayed in the representation.
     */
    @JsonProperty(value = "message")
    private String message;

    /**
     * Default constructor.
     */
    public ExceptionMessage() {
	super();
    }

    /**
     * Constructor for the class that populates all the values.
     *
     * @param errorCode
     *            Integer value for property errorCode
     * @param message
     *            String value for property message
     */
    public ExceptionMessage(final Integer errorCode, final String message) {
	super();
	this.errorCode = errorCode;
	this.message = message;
    }

    /**
     * This implementation gets value for errorCode property.
     *
     * @return Integer with value
     */
    public Integer getErrorCode() {
	return errorCode;
    }

    /**
     * This implementation sets value for errorCode property.
     *
     * @param errorCode
     *            Integer value for property errorCode
     */
    public void setErrorCode(final Integer errorCode) {
	this.errorCode = errorCode;
    }

    /**
     * This implementation gets value for message property.
     *
     * @return String with value
     */
    public String getMessage() {
	return message;
    }

    /**
     * This implementation sets for message property.
     *
     * @param message
     *            String value for property message
     */
    public void setMessage(final String message) {
	this.message = message;
    }

}
