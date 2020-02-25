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
    private By signInBtn = By.cssSelector("ul.user.nav");
    private By registerBtn = By.xpath("//label[contains(text(),'SERVICE PROVIDER']");

    public HomePage openHomePage(){
        driver.get(baseUrl);
        return  this;
    }

    public LoginPage toLoginPage(){
        waitForClick(signInBtn);
        return new LoginPage(driver);
    }

    public RegisterPage toRegisterPage(){
        waitForClick(registerBtn);
        return new RegisterPage(driver);
    }

}
