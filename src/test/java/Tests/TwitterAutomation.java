package Tests;

import Base.TestBase;
import Pages.LoginPage;
import Pages.WelcomePage;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TwitterAutomation extends TestBase {

    WelcomePage welcomePage;
    LoginPage loginPage;

    public void initializer() {
        welcomePage = new WelcomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1, description = "Validate that user can log in with correct credentials")
    public void validateUserCanLogin() {
        initializer();
        getUrl("https://twitter.com/");
        welcomePage.clickSignInBtn();
        loginPage.inputUsername("");
        loginPage.clickNextBtn();
        loginPage.inputPassword("");
        loginPage.clickSigInBtn();
        sleep(10);
    }
}
