package com.example.demo.test;

import java.awt.PageAttributes.MediaType;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.HelloWorldController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=MockServletContext.class)
@WebAppConfiguration
public class HelloWorldTests 
{
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception
    {
    	   mvc=MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    
    @Test
    public void getHello() throws Exception
    {
    	    mvc.perform(MockMvcRequestBuilders.get("/hello").accept(org.springframework.http.MediaType.APPLICATION_JSON))
    	    .andExpect(MockMvcResultMatchers.status().isOk())
    	    .andDo(MockMvcResultHandlers.print())
    	    .andReturn();
    	    
    }
    
    
    
}
