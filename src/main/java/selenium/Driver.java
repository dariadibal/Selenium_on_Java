package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import static org.openqa.selenium.remote.HttpSessionId.getSessionId;

public final class Driver {
    private static Driver instance;

    private WebDriver driver;

    private Driver() {}

    public WebDriver getDriver() {
        if (this.driver == null) {
            this.driver = new ChromeDriver();
        }
        return driver;
    }

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public void close() {
        this.driver.quit();
        this.driver = null;
    }
}
