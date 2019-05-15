package com.assessment.springrequestresponsecheckpoint.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@WebMvcTest(RedactController.class)
public class RedactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRedact() throws Exception {
        this.mockMvc.perform(get("/redact?original=A little of this and a little of that&badWord=little").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("A ****** of this and a ****** of that"));

        this.mockMvc.perform(get("/redact?original=A little of this and a little of that&badWord=little&badWord=this").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("A ****** of **** and a ****** of that"));
    }
}
