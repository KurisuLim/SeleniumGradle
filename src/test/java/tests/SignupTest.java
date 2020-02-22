package tests;

import org.testng.annotations.Test;
import pages.HomePage;


public class SignupTest extends BaseTest{
    /*
    * Ticket 3. Automate Sign Up scenarios
      1. Sign Up Success. (Please make sure you can run your Sign Up test more than 2 times !)
      2. Sign Up Wrong credentials (not existing email)
      3. Sign Up Empty credentials
    *
    * */

    @Test (priority = 0)
    public void emptyCredentials(){
        // The Create Account Button is disable
        // so there is no way to test an empty state
        HomePage homePage = new HomePage(driver);
        homePage.testkwidos()
        .toSignupPage()
        .emptyCredentials()
        .getCurrentUrl("https://testkwidos.tk/auth/register/contractor");

    }

    @Test (priority = 1)
    public void wrongCredentials(){
        // The Create Account Button is disable
        // so basically all field should be correct
        HomePage homePage = new HomePage(driver);
        homePage.testkwidos()
                .toSignupPage()
                .wrongSignUp()
                .signupError();
    }

    @Test (priority = 2)
    public void successSignup(){
        HomePage homePage = new HomePage(driver);
        homePage.testkwidos()
                .toSignupPage()
                .fakerSignup()
                .successAlert();
    }
}
