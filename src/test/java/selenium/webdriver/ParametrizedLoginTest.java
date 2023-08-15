package selenium.webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.TestUser;

import java.util.stream.Stream;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static selenium.Locators.*;

public class ParametrizedLoginTest {

    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }

    @ParameterizedTest
    @DisplayName("Parameterized login test to saucedemo site")
    @MethodSource("usersProvider")
    public void loginTest(TestUser testUser) throws InterruptedException {
        Thread.sleep(3_000); // it's an explicit wait
        driver.get(BASE_URL);
        WebElement usernameInput = driver.findElement(USER_NAME_INPUT_LOCATOR);
        usernameInput.sendKeys(testUser.getUserName());
        WebElement passwordInput = driver.findElement(PASSWORD_INPUT_LOCATOR);
        passwordInput.sendKeys(testUser.getPassword());
        WebElement loginButton = driver.findElement(LOGIN_BUTTON_LOCATOR);
        loginButton.click();
        new WebDriverWait(driver, ofSeconds(6)).until(visibilityOfElementLocated(PRODUCT_PAGE_TITLE_LOCATOR));

        assertEquals(INVENTORY_URL, driver.getCurrentUrl(), "Incorrect URL");
        WebElement productPageTitle = driver.findElement(PRODUCT_PAGE_TITLE_LOCATOR);
        assertTrue(productPageTitle.isDisplayed(), "There is no any object with css class title");
        assertEquals("Products", productPageTitle.getText(), "Wrong title text");
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }

    private static Stream<TestUser> usersProvider() {
        TestUser testUser1 = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
        TestUser testUser2 = new TestUser(System.getenv("TEST_GLITCH_USER"), System.getenv("TEST_PASSWORD"));
        return Stream.of(testUser1, testUser2);
    }
}
