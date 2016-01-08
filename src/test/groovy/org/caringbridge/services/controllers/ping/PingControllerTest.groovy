package org.caringbridge.services.controllers.ping;

import org.caringbridge.services.CBServicesBaseTest;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


/**
 * Class that will test the PingController controller
 * @author Alexandro Blanco <ablanco@caringbridge.org>
 *
 */
class PingControllerTest extends CBServicesBaseTest {

    void"test ping endpoint"()
    {
		when:
			ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/ping"))
		//then:
			//result.andDo(MockMvcResultHandlers.println())
		then:
			result.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("Ping"));
		
	}

    void"test exception representation"()

    {
		when:
			ResultActions result = mvc.perform(MockMvcRequestBuilders.get("/ping/ex"))
		then:
//			StringWriter w = new StringWriter()
//			result.andDo(MockMvcResultHandlers.print(w))
//			print w
			result.andExpect(MockMvcResultMatchers.status().isInternalServerError())
			.andExpect(MockMvcResultMatchers.jsonPath("\$.error_code").isNumber())
			.andExpect(MockMvcResultMatchers.jsonPath("\$.message").exists());
	}

}
