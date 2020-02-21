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
    By signinBtn = By.xpath("//button[contains(text(), 'SIGN IN']");
    By errorLabel = By.className("help-block");
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
        waitFoClick(signinBtn);
        return this;
    }

}
