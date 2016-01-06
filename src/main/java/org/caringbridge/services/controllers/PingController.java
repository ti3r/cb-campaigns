package org.caringbridge.services.controllers;

import org.caringbridge.services.CbServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple rest controller that will display a ping message.
 * This class is just to test the different features of the application
 * stack.
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@RequestMapping(value = "/ping")
@RestController
public class PingController extends CbBaseController {

    /**
     * Rest method that will return Ping message.
     * @return ResponseEntity of String message
     */
    @RequestMapping(method = RequestMethod.GET)
    public final ResponseEntity<String> ping() {
	getLog().info("Ping request");
	return ResponseEntity.ok("Ping");
    }
    
    /**
     * Simple method to test the exception throwing in the application.
     * @return ResponseEntity <String> that should never return
     * @throws CbServiceException always as test
     */
    @RequestMapping(path = "/ex", method = RequestMethod.GET)
    public final ResponseEntity<String> exception() throws CbServiceException {
	getLog().info("throwing exception");
	throw new CbServiceException();
    }
}
