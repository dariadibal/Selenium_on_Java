package selenium.webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest {

    private static final String URL = "https://demo.seleniumeasy.com/javascript-alert-box-demo.html";

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("JavaScript Confirm Box Test")
    public void alertBoxTest() throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath(".//button[@onclick='myAlertFunction()']")).click();
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        assertEquals("I am an alert box!", text, "Incorrect message");
    }

    @Test
    @DisplayName("JavaScript Alert Box Test Accept")
    public void confirmationAcceptTest() throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath(".//button[@onclick='myConfirmFunction()']")).click();
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
        alert.accept();
        String text = driver.findElement(By.id("confirm-demo")).getText();
        assertEquals("You pressed OK!", text, "Incorrect message");
    }

    @Test
    @DisplayName("JavaScript Alert Box Test Cancel")
    public void confirmationCancelTest() throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.xpath(".//button[@onclick='myConfirmFunction()']")).click();
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
        String text = driver.findElement(By.id("confirm-demo")).getText();
        assertEquals("You pressed Cancel!", text, "Incorrect message");
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }
}
