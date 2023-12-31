import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestBrowser {
    public static void main(String[] args) {
        WebDriver driver = null;
        String browser = "chrome";
//        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/java/Resources/Driver/geckodriver.exe");
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            WebDriverManager.firefoxdriver().setup();
        }
        driver.manage().window().maximize();
//        driver.get("https://www.selenium.dev/");
        driver.navigate().to("https://www.selenium.dev/");
        sleep(5);
        WebElement documentation = driver.findElement(By.xpath("(//a[@class='nav-link'])[2]"));
        documentation.click();
        System.out.println("This is the current URL: " + driver.getCurrentUrl());

        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("The Selenium Browser"));
        driver.navigate().back();
        sleep(5);
        driver.navigate().forward();
        sleep(10);
        if(null != driver) {
            driver.quit();
        }
    }
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
