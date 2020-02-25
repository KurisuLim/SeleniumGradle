package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    // element
    public By cardTitle = By.className("card-title");
    public By emailText = By.xpath("//label[contains(text(), 'Email Address']");
    public By emailInput = By.id("email");
    public By passwordText = By.xpath("//label[contains(text(), 'Password']");
    public By passwordInput = By.id("password");
    public By signinBtn = By.cssSelector("button");
    public By errorEmailLabel = By.cssSelector("div.card-content div:nth-child(2) div");
    public By errorPassswordLabel = By.cssSelector("div.card-content div:nth-child(3) div.help-block");
    public By forgotPassText = By.className("forgot");
    public By alertError = By.className("alert-danger");

    //element for success login
    public By navTitle = By.className("navbar-title");
    public By pageHeader = By.className("title");
    public By profileBtn = By.xpath("//label[contains(text(), 'GO TO PROFILE)]");
    public By paymentBtn = By.xpath("//label[contains(text(), 'GO TO PAYMENT INFO)]");

    public LoginPage loginWith(String email, String password){
        setText(emailInput, email);
        setText(passwordInput, password);
        waitForClick(signinBtn);
        return this;
    }
}
