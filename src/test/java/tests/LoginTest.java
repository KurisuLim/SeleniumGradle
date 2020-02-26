package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    /*
    * Ticket 2. Automate Login scenarios
    * Login Empty credentials
    * Login Wrong credentials (not existing email)
    * Login Success.
    *
    * Note: Test sometimes will fail due to Capcha  Images
    * */
    HomePage homePage = new HomePage(driver);
    LoginPage page = new LoginPage(driver);

    @BeforeMethod
    public void loginPage(){
        homePage.openHomePage()
                .toLoginPage();
    }

    @Test (priority = 1)
    public void emptyCredentials(){
        page.loginWith("","");
        homePage.waitVisibility(page.errorEmailLabel);
        Assert.assertEquals(page.errorEmailLabel, "Email is required");
        Assert.assertEquals(page.errorPassswordLabel, "Password is required");
    }

    @Test (priority = 2)
    public void wrongCredentials() {
        page.loginWith("wdwewwe@io.com","TestProRocks2020!");
        homePage.waitVisibility(page.alertError);
        Assert.assertEquals(page.alertError, "Username or password is incorrect");
    }

    @Test (priority = 3)
    public void successLogin(){
        page.loginWith("toffer.lim87+testpro@gmail.com","TestProRocks2020!");
        homePage.waitVisibility(page.pageHeader);
        Assert.assertEquals(page.pageHeader, "Let's get it started!");
    }

}
