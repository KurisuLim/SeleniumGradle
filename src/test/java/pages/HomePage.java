package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends BasePage{

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // base url
    String baseUrl = "https://testkwidos.tk/";

    // page elements
    By signInBtn = By.cssSelector("ul.user.nav");
    By signUpBtn = By.cssSelector("div.guest-home div div label");

    public HomePage testkwidos(){
        driver.get(baseUrl);
        return  this;
    }

    public LoginPage toLoginPage(){
        waitForClick(signInBtn);
        return new LoginPage(driver);
    }

    public SignupPage toSignupPage(){
        waitForClick(signUpBtn);
        return new SignupPage(driver);
    }
}
