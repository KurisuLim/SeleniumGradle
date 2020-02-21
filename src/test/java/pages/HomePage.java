package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.jvm.hotspot.asm.Register;

public class HomePage extends BasePage{

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // base url
    String baseUrl = "https://testkwidos.tk/";

    // page elements
    By navbarToggle = By.className("navbar-toggle");
    By signInBtn = By.className("glyphicon.glyphicon-log-in");
    By registerBtn = By.xpath("//label[contains(text(),'SERVICE PROVIDER']");

    public HomePage testkwidos(){
        driver.get(baseUrl);
        return  this;
    }

    public LoginPage toLoginPage(){
        waitFoClick(navbarToggle);
        waitFoClick(signInBtn);
        return new LoginPage(driver);
    }

    public RegisterPage toRegisterPage(){
        waitFoClick(registerBtn);
        return new RegisterPage(driver);
    }
}
