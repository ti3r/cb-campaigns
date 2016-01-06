package org.caringbridge.services.controllers;

import org.caringbridge.services.CBServicesBaseTest;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import spock.util.matcher.HamcrestMatchers;

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
