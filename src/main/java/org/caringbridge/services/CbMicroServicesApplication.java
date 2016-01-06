package org.caringbridge.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the micro-services application.
 * 
 * @author Alex Blanco <ablanco@caringbridge.org>
 *
 */
@SpringBootApplication
public class CbMicroServicesApplication {


    /**
     * Main entry class for the micro-services application.
     * 
     * @param args
     *            command line arguments
     */
    public static void main(final String[] args) {
	SpringApplication.run(CbMicroServicesApplication.class, args);
    }
}
