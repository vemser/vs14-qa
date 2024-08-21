package automationexercise.factory.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Elements extends BrowserService {

    // Método para pegar um elemento
    public static WebElement element(By by){
        return driver.findElement(by);
    }


}
