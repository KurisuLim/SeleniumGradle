package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    // element
    By cardTitle = By.className("card-title");
    By emailText = By.xpath("//label[contains(text(), 'Email Address']");
    By emailInput = By.id("email");
    By passwordText = By.xpath("//label[contains(text(), 'Password']");
    By passwordInput = By.id("password");
    By signinBtn = By.cssSelector("button");
    By errorEmailLabel = By.cssSelector("div.card-content div:nth-child(2) div");
    By errorPassswordLabel = By.cssSelector("div.card-content div:nth-child(3) div.help-block");
    By forgotPassText = By.className("forgot");
    By alertError = By.className("alert-danger");

    //element for success login
    By navTitle = By.className("navbar-title");
    By pageHeader = By.className("title");
    By profileBtn = By.xpath("//label[contains(text(), 'GO TO PROFILE)]");
    By paymentBtn = By.xpath("//label[contains(text(), 'GO TO PAYMENT INFO)]");

    public LoginPage loginWith(String email, String password){
        setText(emailInput, email);
        setText(passwordInput, password);
        waitForClick(signinBtn);
        return this;
    }

    public LoginPage verifyLoginEmail(String text){
        assertEquals(errorEmailLabel, text);
        return this;
    }

    public LoginPage verifyLoginPassword(String text){
        assertEquals(errorPassswordLabel, text);
        return this;
    }

    public LoginPage errorLabelMessage(String text1, String text2){
        assertEquals(errorEmailLabel, text1);
        assertEquals(errorPassswordLabel, text2);
        return this;
    }

    public LoginPage alertMessage(String text){
        assertEquals(alertError, text);
        return this;
    }

    public LoginPage successLogin(String text){
        assertEquals(pageHeader, text);
        return this;
    }

}
