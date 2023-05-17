package com.javarefresher.maximumchar.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class MaximumCharControllerTest {

    @InjectMocks
    private MaximumCharController controller;
    @Mock
    private MaximumCharService service;
    private MockMvc mockMvc;

    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
    @Test
    public void testInputCantBeNull() throws  Exception{
        String emptyStringExceptionMessage = "Input can not be null or empty";
        String notSmallCaseCharacterExceptionMessage = "Input should contain only smallcase alphabetic letters";

        testNotAcceptableInput(null, emptyStringExceptionMessage);
        testNotAcceptableInput("", emptyStringExceptionMessage);
        testNotAcceptableInput("A", notSmallCaseCharacterExceptionMessage);
        testNotAcceptableInput("asgfA", notSmallCaseCharacterExceptionMessage);
        testNotAcceptableInput("@", notSmallCaseCharacterExceptionMessage);
        testNotAcceptableInput("asgf@", notSmallCaseCharacterExceptionMessage);
        testNotAcceptableInput("#", notSmallCaseCharacterExceptionMessage);
        testNotAcceptableInput("!#$%^&*#", notSmallCaseCharacterExceptionMessage);
    }
    @Test
    public void testInputShouldReturnValue() throws  Exception{
        testAcceptableInput("abcde", "a");
        testAcceptableInput("aaaaaa", "a");
        testAcceptableInput("abcdeabcde", "a");
        testAcceptableInput("aabbbcccc", "c");
    }

    private void testNotAcceptableInput(String input, String exceptionMessage) throws Exception {
        when(service.getMaxFrequencyChar(input)).thenThrow(new IllegalArgumentException(exceptionMessage));
        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/max-frequency/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(input))
                .andExpect(status().isNotAcceptable())
                .andReturn();
    }
    private void testAcceptableInput(String input, String expectedValue) throws Exception{
        when(service.getMaxFrequencyChar(input)).thenReturn(expectedValue);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/max-frequency/")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(input))
                .andExpect(status().isOk())
                .andReturn();
        String actualValue = result.getResponse().getContentAsString();
        assertNotNull(actualValue);
        assertEquals(expectedValue, actualValue);
    }
}
