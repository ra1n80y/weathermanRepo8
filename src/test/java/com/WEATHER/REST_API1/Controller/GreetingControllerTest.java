package com.WEATHER.REST_API1.Controller;

import com.WEATHER.REST_API1.service.IGreetService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(RESTAPI1.class)//Anno targets test unit's source class
public class GreetingControllerTest
{
    @MockBean//This anno creates a copy bean to mimic your actual app function
    private IGreetService service;

    @Autowired
    private MockMvc mockMvc;

    @Test//Test unit anno (Mocking the controller)
    public void testGreetingUnit() throws Exception
    {
        Mockito.when (service.generateWishes ()).thenReturn ("GOOD NIGHT!");

        //Request Obj/ref is mainly for API-Unit tests
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.get ("greeting");

        ResultActions perform = mockMvc.perform (request);

        MvcResult result = perform.andReturn ();
        MockHttpServletResponse response = result.getResponse ();

        //Assertions are usually done with HttpStatus codes
        int status = response.getStatus ();
        assertEquals (200,status);
    }
}
