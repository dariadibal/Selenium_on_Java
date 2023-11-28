package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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
