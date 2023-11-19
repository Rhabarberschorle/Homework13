import org.example.uitests.browser.Browser;
import org.example.uitests.browser.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestClass {
    protected WebDriver driver;

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("browser", "chrome");

        driver = WebDriverFactory.getDriver(Browser.CHROME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    @AfterClass
    public void afterClass() {
        if (driver != null) {
            driver.quit();
        }
    }

//    public static void main(String[] args) {
//        System.getProperties().forEach((k, v) -> System.out.println(k + "   " + v));
//    }
}
