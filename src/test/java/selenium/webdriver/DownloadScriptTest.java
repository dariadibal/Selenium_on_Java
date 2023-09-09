package selenium.webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class DownloadScriptTest {

    private static final String URL = "https://demo.seleniumeasy.com/bootstrap-download-progress-demo.html";

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Download and refresh the page when percentage is >= 50")
    public void refreshPageTest() throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.id("cricle-btn")).click();
        assertTrue(isPercentGraterThenFifty(), "Percent is less than fifty");
        driver.navigate().refresh();
        String percentText = driver.findElement(By.cssSelector(".percenttext")).getText();
        assertEquals("0%", percentText, "Percent is reloaded incorrectly");
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }

    private boolean isPercentGraterThenFifty() {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(ofSeconds(30))
                .pollingEvery(ofSeconds(5))
                .ignoring(StaleElementReferenceException.class);
        return wait.until(driver -> {
            WebElement percent = driver.findElement(By.cssSelector(".percenttext"));
            String percentString = percent.getText().replace("%", "");
            int percentNumber = Integer.parseInt(percentString);
            return percentNumber >= 50;
        });
    }
}

