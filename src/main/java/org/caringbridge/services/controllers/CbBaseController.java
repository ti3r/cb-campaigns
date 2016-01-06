package org.caringbridge.services.controllers;

import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RestController;
/**
 * Abstract Base class for all the controllers.
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@RestController
public abstract class CbBaseController {

    /**
     * Final Logger class that will serve for all the controllers to 
     * log messages.
     */
    private static final Logger LOG = Logger.getLogger("Controllers");

    /**
     * Final method to return the logger of the controllers for the app.
     * @return Logger object created for all the controllers.
     */
    public final Logger getLog() {
	return LOG;
    }
}
