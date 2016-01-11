package org.caringbridge.services.controllers.ping;

import org.caringbridge.services.CbServiceException;
import org.caringbridge.services.controllers.CbBaseController;
import org.caringbridge.services.exceptions.CbGoalNotFoundException;
import org.caringbridge.services.exceptions.CbPersonNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mangofactory.swagger.models.dto.Authorization;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;

/**
 * Simple rest controller that will display a ping message. This class is just
 * to test the different features of the application stack.
 *
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
@Api(basePath = "/ping", description = "Simple Ping service to check application health", value = "ping", consumes = "*/*", produces = "text/plain, application/json")
@RequestMapping(value = "/ping")
@RestController
public class PingController extends CbBaseController {

    /**
     * Rest method that will return Ping message.
     *
     * @return ResponseEntity of String message
     */
    @ApiOperation(value = "ping", httpMethod = "GET", consumes = "*/*", produces = "text/plain", notes = "Produces a Ping message for the client in order to check the health of the service")
    @ApiResponse(code = 200, message = "Ping message in the response body as plain text")
    @RequestMapping(method = RequestMethod.GET)
    public final ResponseEntity<String> ping() {
	getLog().info("Ping request");
	return ResponseEntity.ok("Ping");
    }

    /**
     * Simple method to test the exception throwing in the application.
     *
     * @return ResponseEntity <String> that should never return
     * @throws CbServiceException
     *             always as test
     */
    @ApiOperation(value = "ex", httpMethod = "GET", consumes = "*/*", produces = "application/json", notes = "Produces a simple error in the system to check the health of the serialization"
	    + "mechanism of exceptions to json representations")
    @RequestMapping(path = "/ex", method = RequestMethod.GET)
    public final ResponseEntity<String> exception() throws CbServiceException {
	getLog().info("throwing exception");
	throw new CbServiceException();
    }


    /**
     *
     * @return ResponseEntity <String> that should never return
     * @throws CbGoalNotFoundException always as test
     */
    @ApiOperation(value = "goalNotFound", httpMethod = "GET", consumes = "*/*", produces = "application/json", notes = "Produces a GoalNotFound error in the system to check the health of the serialization"
	    + "mechanism of exceptions to json representations")
    @RequestMapping(path = "/goal", method = RequestMethod.GET)
    public final ResponseEntity<String> goalNotFoundException() throws CbGoalNotFoundException {
	getLog().info("throwing GoalNotFoundException");
	throw new CbGoalNotFoundException();
    }

    /**
     *
     * @return ResponseEntity <String> that should never return
     * @throws CbPersonNotFoundException
     */
    @ApiOperation(value = "personNotFound", httpMethod = "GET", consumes = "*/*", produces = "application/json", notes = "Produces a PersonNotFound error in the system to check the health of the serialization"
	    + "mechanism of exceptions to json representations")
    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public final ResponseEntity<String> personNotFoundException() throws CbPersonNotFoundException {
	getLog().info("throwing PersonNotFoundException");
	throw new CbPersonNotFoundException();
    }
}
