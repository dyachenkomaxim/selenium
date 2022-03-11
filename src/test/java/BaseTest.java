import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    void setup() throws MalformedURLException {
        DesiredCapabilities abilities = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://192.168.0.16:4444"), abilities);

    }
    @Test
    void firsttest () {
        driver.navigate().to("http://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        assertTrue(driver.findElement(By.id("flash-messages")).isDisplayed());
        
    }
    @AfterEach
    void teardown() {
        driver.close();
        driver.quit();
    }
}

