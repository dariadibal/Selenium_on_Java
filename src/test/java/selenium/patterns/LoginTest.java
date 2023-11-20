package selenium.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.Screenshot;
import selenium.TestUser;
import selenium.pages.LoginPageWithPF;
import selenium.pages.ProductPageWithPF;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static selenium.Screenshot.*;

public class LoginTest extends BaseTest {
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    private TestUser testUser;

    @BeforeEach
    public void setup() {
        testUser = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
    }

    @Test
    @DisplayName("Login test with page factory for saucedemo site")
    public void loginTest() throws IOException {
        LoginPageWithPF loginPage = openApp();
        takeScreenshot("./screenshots/loginPage.png");
        ProductPageWithPF productPage = loginPage.login(testUser);
        takeScreenshot("./screenshots/productPage.png");

        assertEquals(INVENTORY_URL, productPage.getURL(), "Incorrect URL");
        assertEquals("Products", productPage.getTitle(), "Wrong title text");
    }
}
