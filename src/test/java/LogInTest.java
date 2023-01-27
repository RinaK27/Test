import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class LogInTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    void tearsDown() {
        driver.quit();
        driver = null;
    }
    @Test
    void shouldTest() {
        driver.get("http://u920152e.beget.tech/#");
        driver.findElement(By.cssSelector("[name='auth_email']")).sendKeys("email@domain.com");
        driver.findElement(By.cssSelector("[name='auth_pass']")).sendKeys("12345");
        driver.findElement(By.cssSelector("[name='form_auth_submit']")).click();
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "http://u920152e.beget.tech/page1.html?auth_email=email%40domain.com&auth_pass=12345&form_auth_submit=";
        Assertions.assertEquals(expectedUrl,actualUrl);
    }
}