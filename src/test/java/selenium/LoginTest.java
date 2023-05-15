package selenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;
import static selenium.Locators.*;

public class LoginTest {

    private WebDriver driver;
    private TestUser testUser;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        testUser = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
    }

    @Test
    @DisplayName("Login test for saucedemo site")
    public void loginTest() {
        driver.get("https://www.saucedemo.com/");
        WebElement usernameInput = driver.findElement(USER_NAME_INPUT_LOCATOR);
        usernameInput.sendKeys(testUser.getUserName());
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordInput.sendKeys(testUser.getPassword());
        WebElement loginButton = driver.findElement(LOGIN_BUTTON_LOCATOR);
        loginButton.click();

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl(), "Incorrect URL");
        WebElement productPageTitle = driver.findElement(PRODUCT_PAGE_TITLE_LOCATOR);
        assertTrue(productPageTitle.isDisplayed(), "There is no any object with css class title");
        assertEquals("Products", productPageTitle.getText(), "Wrong title text");
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }
}
