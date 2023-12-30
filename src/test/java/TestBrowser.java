import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
        driver.get("https://www.selenium.dev/");
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
