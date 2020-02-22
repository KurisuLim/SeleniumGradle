package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    //element
    By firstName = By.cssSelector("[formcontrolname=firstName]");
    By firstNameError = By.cssSelector("[errormsg=Please enter your First name]");

    By lastName = By.cssSelector("[formcontrolname=lastName]");
    By lastNameError = By.cssSelector("[errormsg=Please enter your Last name]");

    By businessName = By.cssSelector("[formcontrolname=businessName]");
    By businessError = By.cssSelector("[errormsg=Please enter your Business name]");

    By phone = By.cssSelector("[formcontrolname=phone]");
    By phoneError = By.cssSelector("div.card-content div:nth-child(4) div app-field-error-display div div small");

    By email = By.cssSelector("[formcontrolname=email]");
    By emailError = By.cssSelector("div.card-content div:nth-child(5) div app-field-error-display div div small");

    By password = By.cssSelector("[formcontrolname=password]");
    By passwordError = By.cssSelector("div.card-content div:nth-child(6) div app-field-error-display div div small");

    By privacyCheckbox = By.cssSelector("div.card-content div:nth-child(8) div p-checkbox");

    By createAccBtn = By.cssSelector("button.btn-danger");
    By alert = By.cssSelector(".alert");

    public SignupPage emptyCredentials(){
        setText(firstName, "");
        setText(lastName, "");
        setText(businessName, "");
        setText(phone, "");
        setText(email, "");
        setText(password, "1");
        return this;
    }

    public SignupPage wrongSignUp(){
        setText(firstName, "Chris");
        setText(lastName, "Lim");
        setText(businessName, "Testing Program");
        setText(phone, "1");
        setText(email, "1");
        setText(password, "1234567");
        waitForClick(privacyCheckbox);

        return this;
    }

    public SignupPage signupError(){
        String error1 = "Please enter correct phone";
        String error2 = "Please enter your Email address";
        String error3 = "Password must be at least 8 characters long, must consist of at least 1 upper case letter, at least 1 special character and at least 1 number";

        assertEquals(phoneError, error1);
        assertEquals(emailError, error2);
        return this;
    }

    public SignupPage getCurrentUrl(String url){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, url);

        return this;
    }

    public SignupPage fakerSignup(){
        Faker faker = new Faker();

        String fakeFirstName = faker.name().firstName();
        String fakeLastName = faker.name().lastName();
        String fakeBusinessName = faker.company().industry();
        String fakePhoneNumber = faker.phoneNumber().phoneNumber();
        String fakeEmailAddress = faker.name().firstName();
        String fakePassword = faker.internet().password();

        setText(firstName, fakeFirstName);
        setText(lastName, fakeLastName);
        setText(businessName, fakeBusinessName);
        setText(phone, fakePhoneNumber);
        setText(email, fakeFirstName + fakeEmailAddress + "@example.org");
        setText(password, fakePassword +"A4!");
        waitForClick(privacyCheckbox);
        waitForClick(createAccBtn);
        return this;
    }

    public SignupPage successAlert(){
        assertTrue(alert);
        return this;
    }
}
