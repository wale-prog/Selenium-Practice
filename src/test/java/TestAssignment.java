import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAssignment extends TestBase {
    WebElement usernameField;
    WebElement passwordField;

    WebElement login;

    @Test(priority = 1, description = "Validate that User cannot login using wrong credentials")
    public void validateUserCannotLoginUsingWrongCredentials(){

        // Navigate to the website url
        getUrl("https://the-internet.herokuapp.com/");
        sleep(5);

        // Navigate to Form Authentication and Click it
        driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
        sleep(3);

        // Locate web elements (Username and Password)
        usernameField = driver.findElement(By.xpath("(//input)[1]"));

        passwordField = driver.findElement(By.xpath("(//input)[2]"));

        sleep(3);

        // Input Username and password into the fields located
        usernameField.sendKeys("tomsmith");
        sleep(3);
        passwordField.sendKeys("SuperSecretPassword");

        sleep(3);

        // Next we find the login element on the page
        login = driver.findElement(By.xpath("(//button)"));
        login.click();

        sleep(5);

        // Asserting if the login was successful or not
        WebElement errorMessage = driver.findElement(By.id("flash"));

        System.out.println(errorMessage.getText());

        Assert.assertTrue(errorMessage.getText().contains("Your password is invalid!"));
        sleep(10);
    }

    @Test(priority = 2, description = "Validate that users can login using correct credentials")
    public void validateUserCanLoginWithCorrectCredentials() {

        usernameField = driver.findElement(By.xpath("(//input)[1]"));

        passwordField = driver.findElement(By.xpath("(//input)[2]"));

        // Input Username and password into the fields located
        usernameField.sendKeys("tomsmith");
        sleep(3);
        passwordField.sendKeys("SuperSecretPassword!");

        // Next we find the login element on the page
        login = driver.findElement(By.xpath("(//button)"));
        login.click();

        sleep(5);
    }
}

