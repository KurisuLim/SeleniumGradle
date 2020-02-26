package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;


public class SignupTest extends BaseTest{
    /*
    * Ticket 3. Automate Sign Up scenarios
      1. Sign Up Success. (Please make sure you can run your Sign Up test more than 2 times !)
      2. Sign Up Wrong credentials (not existing email)
      3. Sign Up Empty credentials
    *
    * */
    HomePage homePage = new HomePage(driver);
    SignupPage page = new SignupPage(driver);

    @BeforeTest
    public void beforeTest(){
        homePage.openHomePage()
                .toSignupPage();
    }

    @Test (priority = 1)
    public void emptyCredentials(){
        // The Create Account Button is disable
        // so there is no way to test an empty state
        String currentUrl = driver.getCurrentUrl();
        page.emptyCredentials();
        Assert.assertEquals(currentUrl, "https://testkwidos.tk/auth/register/contractor");



    }

    @Test (priority = 2)
    public void wrongCredentials(){
        // The Create Account Button is disable
        // so basically all field should be correct
        page.wrongSignUp();
        homePage.waitVisibility(page.phoneError);
        Assert.assertEquals(page.passwordError, "Please enter correct phone");
    }

    @Test (priority = 3)
    public void successSignup(){
        page.fakerSignup();
        homePage.waitVisibility(page.alert);
        Assert.assertTrue(driver.findElement(page.alert).isDisplayed());
    }
}
