package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    User user = new User();
    Faker faker = new Faker();

    //element
    public By firstName = By.cssSelector("[formcontrolname=firstName]");
    public By firstNameError = By.cssSelector("[errormsg=Please enter your First name]");

    public By lastName = By.cssSelector("[formcontrolname=lastName]");
    public By lastNameError = By.cssSelector("[errormsg=Please enter your Last name]");

    public By businessName = By.cssSelector("[formcontrolname=businessName]");
    public By businessError = By.cssSelector("[errormsg=Please enter your Business name]");

    public By phone = By.cssSelector("[formcontrolname=phone]");
    public By phoneError = By.cssSelector("div.card-content div:nth-child(4) div app-field-error-display div div small");

    public By email = By.cssSelector("[formcontrolname=email]");
    public By emailError = By.cssSelector("div.card-content div:nth-child(5) div app-field-error-display div div small");

    public By password = By.cssSelector("[formcontrolname=password]");
    public By passwordError = By.cssSelector("div.card-content div:nth-child(6) div app-field-error-display div div small");

    public By privacyCheckbox = By.cssSelector("div.card-content div:nth-child(8) div p-checkbox");

    public By createAccBtn = By.cssSelector("button.btn-danger");
    public By alert = By.cssSelector(".alert");

    public SignupPage emptyCredentials(){
        setText(firstName, user.emptyCredentials().firstName);
        setText(lastName, user.emptyCredentials().lastName);
        setText(businessName, user.emptyCredentials().businessName);
        setText(phone, user.emptyCredentials().phone);
        setText(email, user.emptyCredentials().email);
        setText(password, user.emptyCredentials().password);

        waitForClick(privacyCheckbox);
        return this;
    }

    public SignupPage wrongSignUp(){
        setText(firstName, user.wrongSignUp().firstName);
        setText(lastName, user.wrongSignUp().lastName);
        setText(businessName, user.wrongSignUp().businessName);
        setText(phone, user.wrongSignUp().phone);
        setText(email, user.wrongSignUp().email);
        setText(password, user.wrongSignUp().password);

        waitForClick(privacyCheckbox);
        return this;
    }

    public SignupPage fakerSignup(){
        setText(firstName,faker.name().firstName();
        setText(lastName, faker.name().lastName());
        setText(businessName, faker.company().industry());
        setText(phone, faker.phoneNumber().phoneNumber());
        setText(email, faker.name().firstName() + faker.name().firstName() + "@example.org");
        setText(password, faker.internet().password() +"A4!");
        waitForClick(privacyCheckbox);
        waitForClick(createAccBtn);
        return this;
    }

    public SignupPage successAlert(){
        assertTrue(alert);
        return this;
    }
}
