package selenium.patterns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.Driver;
import selenium.TestUser;
import selenium.pages.BurgerMenu;
import selenium.pages.LoginPageWithPF;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static selenium.Properties.*;

public class LogoutTest extends BaseTest {
    private TestUser testUser;

    @BeforeEach
    public void setup() {
        testUser = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
    }

    @Test
    @DisplayName("Logout test with page factory for saucedemo site")
    public void logoutTest() {
        LoginPageWithPF loginPage = openApp();
        loginPage.login(testUser);
        BurgerMenu menu = new BurgerMenu(Driver.getInstance().getDriver());

        assertEquals(LOGIN_URL, menu.logout().getURL(), "Incorrect URL");
    }
}
