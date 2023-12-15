package selenium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.MalformedURLException;

public class SauceTestWatcher implements TestWatcher {
    @Override
    public void testSuccessful(ExtensionContext context) {
        RemoteWebDriver driver = null;
        try {
            if (PropertiesManager.getInstance().getProperties().getProperty("platform").equals("local")) {
                return;
            }
            driver = (RemoteWebDriver) (Driver.getInstance().getDriver());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.executeScript("sauce:job-result=passed");
        driver.quit();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        RemoteWebDriver driver = null;
        try {
            if (PropertiesManager.getInstance().getProperties().getProperty("platform").equals("local")) {
                return;
            }
            driver = (RemoteWebDriver) (Driver.getInstance().getDriver());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.executeScript("sauce:job-result=failed");
        driver.quit();
    }
}
