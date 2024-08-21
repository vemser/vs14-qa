package automationexercise.page;

import automationexercise.factory.selenium.Interactions;
import org.openqa.selenium.By;

public class LoginPage extends Interactions {

    private static final By campoEmail =
    By.cssSelector("input[data-qa=\"login-email\"]");
    private static final By campoSenha =
    By.cssSelector("[data-qa=\"login-password\"]");
    private static final By btnAcessar =
    By.cssSelector("#form  div div div.col-sm-4.col-sm-offset-1 div  form > button");
    private static final By TextMsgmBtn =
    By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a");
    private static final By msgmEmailIncorreto =
    By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p");

    public void preencherCampoEmail(String email){
        sendKeys(campoEmail,email);
    }

    public void preencherCampoSenha(String senha){
        sendKeys(campoSenha,senha);
    }

    public void clicarBtnAcessar(){
        click(btnAcessar);
    }
    public String validarTextoBtnAposLogin(){
        return lerTexto(TextMsgmBtn);
    }
    public String validarMsgmEmailIncorreto(){
        return lerTexto(msgmEmailIncorreto);
    }

    public String fazerLogin(String email, String senha){
        sendKeys(campoEmail,email);
        sendKeys(campoSenha,senha);
        click(btnAcessar);
        return lerTexto(TextMsgmBtn);
    }
    public String loginEmailIncorreto(String email, String senha){
        sendKeys(campoEmail,email);
        sendKeys(campoSenha,senha);
        click(btnAcessar);
        return lerTexto(msgmEmailIncorreto);
    }
}
