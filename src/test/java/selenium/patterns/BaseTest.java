package selenium.patterns;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;
import selenium.Driver;
import selenium.Properties;
import selenium.pages.LoginPageWithPF;

import java.net.MalformedURLException;

public class BaseTest {

    @AfterEach
    public void cleanup() {
        Driver.getInstance().close();
    }

    @Step("Open App")
    protected LoginPageWithPF openApp() throws MalformedURLException {
        WebDriver driver = Driver.getInstance().getDriver();
        driver.get(Properties.LOGIN_URL);
        return new LoginPageWithPF(driver);
    }
}
