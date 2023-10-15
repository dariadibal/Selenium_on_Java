package selenium.patterns;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.Driver;
import selenium.TestUser;
import selenium.pages.BurgerMenu;
import selenium.pages.LoginPageWithPF;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutTestWithPageFactory {
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    private LoginPageWithPF loginPage;
    private BurgerMenu menu;
    private TestUser testUser;

    @BeforeEach
    public void setup() {
        loginPage = new LoginPageWithPF();
        testUser = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
        menu = new BurgerMenu();
    }

    @Test
    @DisplayName("Logout test with page factory for saucedemo site")
    public void logoutTest() {
        loginPage.openPage();
        loginPage.login(testUser);
        menu.logout();

        assertEquals(LOGIN_URL, loginPage.getURL(), "Incorrect URL");
    }

    @AfterEach
    public void cleanup() {
        Driver.close();
    }
}
