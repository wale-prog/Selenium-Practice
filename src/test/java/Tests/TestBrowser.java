package Tests;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TestBrowser extends TestBase {

    @Test(priority = 0, description = "Validate user can click on the checkboxes")
    public void main() {
        driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        for (int i = 0; i < checkboxes.size(); i += 1) {
            checkboxes.get(i).click();
        }
        sleep(10);
    }
}
