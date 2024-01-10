import Base.TestBase;
import Pages.LoginPage;
import Pages.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssignment extends TestBase {

    WelcomePage welcomePage;
    LoginPage loginPage;

    @Test(priority = 1, description = "Validate that User cannot login using wrong credentials")
    public void validateUserCannotLoginUsingWrongCredentials() {

        welcomePage = new WelcomePage(driver);
        loginPage = new LoginPage(driver);
        // Navigate to the website url
        getUrl("https://the-internet.herokuapp.com/");
        welcomePage.clickForm();

        // Locate web elements (Username and Password)
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword");
        // Next we find the login element on the page
        loginPage.clickLoginBtn();

        // Asserting if the login was successful or not
        WebElement errorMessage = loginPage.getErrorMsg();
        System.out.println(errorMessage.getText());
        Assert.assertTrue(errorMessage.getText().contains("Your password is invalid!"));
        sleep(10);
    }

    @Test(priority = 2, description = "Validate that users can login using correct credentials")
    public void validateUserCanLoginWithCorrectCredentials() {

        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLoginBtn();
        sleep(5);
    }
}

