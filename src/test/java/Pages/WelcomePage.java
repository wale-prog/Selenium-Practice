package Pages;

import Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WelcomePage extends PageBase {

    WebDriver driver;
    public WelcomePage(WebDriver driver) {
        super(driver);
    }
    LoginPage loginPage = new LoginPage(driver);

    @FindBy(xpath = "//a[text()='Form Authentication']")
    WebElement form;
    @FindBy(xpath = "//a[@href='/login']")
    WebElement signInBtn;

    public void clickForm() {
        click(form);
    }
    public void clickSignInBtn() {
        click(signInBtn);
    }
}
