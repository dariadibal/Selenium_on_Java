package selenium.patterns;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import selenium.Driver;
import selenium.TestUser;
import selenium.pages.LoginPageWithPF;
import selenium.pages.ProductPageWithPF;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTestWithPageFactory {
    private static final String INVENTORY_URL = "https://www.saucedemo.com/inventory.html";
    private LoginPageWithPF loginPage;
    private ProductPageWithPF productPage;
    private TestUser testUser;

    @BeforeEach
    public  void setup() {
        loginPage = new LoginPageWithPF();
        productPage = new ProductPageWithPF();
        testUser = new TestUser(System.getenv("TEST_USER"), System.getenv("TEST_PASSWORD"));
    }

    @Test
    @DisplayName("Login test with page factory for saucedemo site")
    public void loginTest() {
        loginPage.openPage();
        loginPage.login(testUser);

        assertEquals(INVENTORY_URL, productPage.getURL(), "Incorrect URL");
        assertEquals("Products", productPage.getTitle(), "Wrong title text");
    }

    @AfterEach
    public void cleanup() {
        Driver.close();
    }
}
