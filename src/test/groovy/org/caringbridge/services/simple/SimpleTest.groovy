package org.caringbridge.services.simple

import org.caringbridge.services.CBServicesBaseTest

class SimpleTest extends CBServicesBaseTest {

    void"Test Something simple to check context build"()
    {
		when:
			Object o = new Object()
		then:
			o != null
	}

}
