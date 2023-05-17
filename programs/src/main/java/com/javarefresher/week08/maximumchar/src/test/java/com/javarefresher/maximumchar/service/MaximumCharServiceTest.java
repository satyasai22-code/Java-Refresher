package com.javarefresher.maximumchar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class MaximumCharServiceTest {
    @InjectMocks
    private MaximumCharService service;

    @Mock
    private MaximumfrequencyCharacter util;


    @BeforeEach
    public void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionErrorForEmptyInput(){
        String emptyStringExceptionMessage = "Input can not be null or empty";
        Mockito.when(util.getMaximumChar("")).thenThrow(new IllegalArgumentException(emptyStringExceptionMessage));
        IllegalArgumentException actualException = assertThrows(
                IllegalArgumentException.class,  service.getMaxFrequencyChar(""));

        assertEquals(emptyStringExceptionMessage, actualException.getMessage());
    }
    @Test
    public void shouldThrowIllegalArgumentExceptionErrorForNonSmallCaseInput() throws Exception{
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
    private  void testNotAcceptableInput(String input, String exceptionMessage) throws Exception{
        Mockito.when(util.getMaximumChar(input)).thenThrow(new IllegalArgumentException(exceptionMessage));
        IllegalArgumentException actualException = assertThrows(
                IllegalArgumentException.class, service.getMaxFrequencyChar(input));
        assertEquals(exceptionMessage, actualException.getMessage());
    }

    @Test
    public void testInputShouldReturnValue() throws  Exception{
        testAcceptableInput("abcde", "a");
        testAcceptableInput("aaaaaa", "a");
        testAcceptableInput("abcdeabcde", "a");
        testAcceptableInput("aabbbcccc", "c");
    }
    private void testAcceptableInput(String input, String expectedValue) throws Exception{
        Mockito.when(util.getMaximumChar(input)).thenReturn(expectedValue);
        assertEquals(expectedValue, service.getMaxFrequencyChar(input));
    }
}
