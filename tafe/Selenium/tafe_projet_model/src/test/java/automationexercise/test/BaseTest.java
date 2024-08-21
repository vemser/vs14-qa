package automationexercise.test;

import automationexercise.factory.selenium.BrowserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest extends BrowserService {

    @BeforeEach
    public void abrirNavegador(){
        initChromeDriver("https://www.automationexercise.com/login");
    }

    @AfterEach
    public void fecharNavegador(){
        quit();
    }

}
