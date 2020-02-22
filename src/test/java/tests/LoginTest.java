package tests;

import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTest extends BaseTest {
    /*
    * Ticket 2. Automate Login scenarios
    * Login Empty credentials
    * Login Wrong credentials (not existing email)
    * Login Success.
    *
    * Note: Test sometimes will fail due to Capcha  Images
    * */

    @Test (priority = 0)
    public void emptyCredentials(){

        HomePage homePage = new HomePage(driver);
        homePage.testkwidos()
                .toLoginPage()
                .loginWith("","")
                .errorLabelMessage("Email is required","Password is required");
    }

    @Test (priority = 1)
    public void wrongCredentials() {
        HomePage homePage = new HomePage(driver);
        homePage.testkwidos()
                .toLoginPage()
                .loginWith("wdwewwe@io.com","TestProRocks2020!")
                .alertMessage("Username or password is incorrect");
    }

    @Test (priority = 2)
    public void successLogin(){
        HomePage homePage = new HomePage(driver);
        homePage.testkwidos()
                .toLoginPage()
                .loginWith("toffer.lim87+testpro@gmail.com","TestProRocks2020!")
                .successLogin("Let's get it started!");

    }

}
