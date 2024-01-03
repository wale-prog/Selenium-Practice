import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static WebDriver driver;
    @BeforeClass
    public void setup() {
        System.out.println("Inside the before class annotation");
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
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }
    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Inside the before method annotation");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Inside the after method annotation");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Inside the after class annotation");
        if (null != driver) {
            driver.quit();
        }
    }
}
