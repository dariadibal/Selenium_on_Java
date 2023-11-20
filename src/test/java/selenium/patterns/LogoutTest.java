package selenium.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.Driver;
import selenium.TestUser;
import selenium.pages.BurgerMenu;
import selenium.pages.LoginPageWithPF;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static selenium.Screenshot.takeScreenshot;
import static selenium.Properties.*;

public class LogoutTest extends BaseTest {
    private TestUser testUser;

    @BeforeEach
    public void setup() {
        testUser = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
    }

    @Test
    @DisplayName("Logout test with page factory for saucedemo site")
    public void logoutTest() throws IOException {
        LoginPageWithPF loginPage = openApp();
        takeScreenshot("./screenshots/LoginPage1.png");
        loginPage.login(testUser);
        BurgerMenu menu = new BurgerMenu(Driver.getInstance().getDriver());
        takeScreenshot("./screenshots/productPage1.png");

        assertEquals(LOGIN_URL, menu.logout().getURL(), "Incorrect URL");
    }
}
