package selenium.patterns;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import selenium.SauceTestWatcher;
import selenium.SeleniumTestWatcher;
import selenium.TestUser;
import selenium.pages.LoginPageWithPF;
import selenium.pages.ProductPageWithPF;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static selenium.Screenshot.*;

@ExtendWith({
        SeleniumTestWatcher.class,
        SauceTestWatcher.class
})
public class LoginTest extends BaseTest {
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    private TestUser testUser;

    @BeforeEach
    public void setup() {
        testUser = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
    }

    @Test
    @DisplayName("Login test with page factory for saucedemo site")
    @Description("Login Test")
    @Epic("Login / Logout Functionality Epic")
    @TmsLink("ID-765")
    @Tags({
            @Tag("Chrome"),
            @Tag("118")
    })
    public void loginTest() throws IOException {
        Allure.label("Browser", "Chrome");
        LoginPageWithPF loginPage = openApp();
        takeScreenshot("./screenshots/loginPage.png");
        ProductPageWithPF productPage = loginPage.login(testUser);
        takeScreenshot("./screenshots/productPage.png");

        assertEquals(INVENTORY_URL, productPage.getURL(), "Incorrect URL");
        assertEquals("Products", productPage.getTitle(), "Wrong title text");
    }
}
