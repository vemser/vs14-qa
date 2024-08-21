package automationexercise.factory.selenium;

import org.junit.jupiter.api.Assertions;

public class Validation {

    public void validateText(String expected, String Actual){
        Assertions.assertEquals(expected,Actual);
    }


}
