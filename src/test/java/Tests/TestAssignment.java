package Tests;

import Base.TestBase;
import Pages.LoginPage;
import Pages.WelcomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class TestAssignment extends TestBase {

    WelcomePage welcomePage;
    LoginPage loginPage;

    String current;

    @Test(priority = 1, description = "Validate that User cannot login using wrong credentials")
    public void validateUserCannotLoginUsingWrongCredentials() {

        welcomePage = new WelcomePage(driver);
        loginPage = new LoginPage(driver);
        // Navigate to the website url
        getUrl(testData.getProperty("baseURL"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("window.scrollBy(0, 750)");
        Actions actions = new Actions(driver);
        current = driver.getWindowHandle();
        System.out.println("The current tab id is: " + current);
        actions.keyDown(Keys.CONTROL).click(welcomePage.getForm()).keyUp(Keys.CONTROL).build().perform();
        Set<String> allTabs = driver.getWindowHandles();
        System.out.println("The number of tabs is: " + allTabs.size());
//        for(String tab : allTabs) {
//            if(current != tab) {
//                driver.switchTo().window(tab);
//            }
//        }
        Iterator<String> iterator = allTabs.iterator();
        while(iterator.hasNext()) {
            String child = iterator.next();
            if(!current.equals(child)) {
                driver.switchTo().window(child);
            }
        }
        sleep(10);
//        jsExecutor.executeScript("arguments[0].click()", welcomePage.getForm());
//        welcomePage.clickForm();
        // Locate web elements (Username and Password)
        loginPage.enterUsername(testData.getProperty("username"));
        loginPage.enterPassword(testData.getProperty("wrongPassword"));
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

        loginPage.enterUsername(testData.getProperty("username"));
        loginPage.enterPassword(testData.getProperty("password"));
        loginPage.clickLoginBtn();
        driver.close();
        driver.switchTo().window(current);
        sleep(10);
    }
}

