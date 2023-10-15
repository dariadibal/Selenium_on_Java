package selenium.patterns;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import selenium.Driver;
import selenium.Properties;
import selenium.pages.LoginPageWithPF;

public class BaseTest {

    @AfterEach
    public void cleanup() {
        Driver.getInstance().close();
    }

    protected LoginPageWithPF openApp() {
        WebDriver driver = Driver.getInstance().getDriver();
        driver.get(Properties.LOGIN_URL);
        return new LoginPageWithPF(driver);
    }
}
