package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class Driver {
    private static Driver instance;

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private Driver() {}

    public WebDriver getDriver() throws MalformedURLException {
        if (this.driver.get() == null) {
            ChromeOptions options = new ChromeOptions();
            driver.set(new RemoteWebDriver(new URL("http://localhost:4444"), options));
        }
        return this.driver.get();
    }

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public void close() {
        this.driver.get().quit();
    }
}
