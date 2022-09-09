import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    WebDriver webDriver;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/Users/elenapopova/Downloads/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.navigate().to
                ("http://automationpractice.com/index.php");
        webDriver.manage().window().maximize();
    }

    //@AfterTest
    //public void cleanUp() {
       // webDriver.quit();
    //}
}
