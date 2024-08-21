package automationexercise.factory.selenium;


import org.openqa.selenium.By;

import static automationexercise.factory.selenium.Waits.waitElement;

public class Interactions extends Elements {

    protected static void sendKeys(By by, String text) {
        waitElement(by);
        element(by).sendKeys(text);
    }

    protected static void click(By by) {
        waitElement(by);
        element(by).click();
    }

    protected static String lerTexto(By by) {
        waitElement(by);
        return element(by).getText();
    }

    protected static void sendTab(By by){
        waitElement(by);
        element(by).sendKeys("\t");
    }


}
