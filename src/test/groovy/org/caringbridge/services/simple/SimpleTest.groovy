package org.caringbridge.services.simple

import org.caringbridge.services.CBServicesBaseTest
/**
 * Simple test class to check the correct context 
 * construction of the application.
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
class SimpleTest extends CBServicesBaseTest {

    void"Test Something simple to check context build"()
    {
		when:
			Object o = new Object()
		then:
			o != null
	}

}
