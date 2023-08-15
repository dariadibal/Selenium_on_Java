package selenium.webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class WaitingForUserTest {

    private static final String URL = "https://demo.seleniumeasy.com/dynamic-data-loading-demo.html";
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Script which waits for user")
    public void waitUserTest() {
        driver.get(URL);
        driver.findElement(By.id("save")).click();
        new WebDriverWait(driver, ofSeconds(6)).until(textToBePresentInElementLocated(By.cssSelector("#loading"),
                "First Name"));
        WebElement userCard = driver.findElement(By.id("loading"));
        assertTrue(userCard.getText().contains("Last Name"));
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }
}

