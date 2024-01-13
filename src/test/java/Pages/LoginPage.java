package Pages;

import Base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "(//input)[1]")
//    WebElement usernameField;
    @FindBy(xpath = "(//input)[2]")
    WebElement passwordField;
    @FindBy(xpath = "(//button)")
    WebElement loginBtn;
    @FindBy(id = "flash")
    WebElement errorMsg;
    @FindBy(tagName = "input")
    private WebElement usernameField;
    @FindBy(xpath = "(//div[@role='button'])[3]")
    WebElement nextBtn;
    @FindBy(xpath = "(//div[@role='button'])[3]")
    WebElement SignInBtn;
    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    public void enterUsername(String username) {
        enterText(usernameField, username);
    }
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }
    public void clickLoginBtn() {
        click(loginBtn);
    }
    public WebElement getErrorMsg() {
        return errorMsg;
    }
    public void inputUsername(String username) {
        enterText(usernameField, username);
    }
    public void clickNextBtn() {
        click(nextBtn);
    }
    public void inputPassword(String password) {
        enterText(passwordInput, password);
    }
    public void clickSigInBtn() {
        click(SignInBtn);
    }
}
