package selenium.factories;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemotePlatformFactory implements PlatformFactory {
    @Override
    public RemoteWebDriver createChrome() throws MalformedURLException {
        ChromeBrowser browserOptions = new ChromeBrowser();
        ChromeOptions options = browserOptions.getOptions();
        options.setPlatformName("Linux");
        options.setBrowserVersion("latest");
        options.setCapability("sauce:options", sauceOptions);
        return new RemoteWebDriver(new URL(url), options);
    }

    @Override
    public RemoteWebDriver createFirefox() throws MalformedURLException {
        FirefoxBrowser browserOptions = new FirefoxBrowser();
        FirefoxOptions options = browserOptions.getOptions();
        options.setPlatformName("Windows 11");
        options.setBrowserVersion("latest");
        options.setCapability("sauce:options", sauceOptions);
        return new RemoteWebDriver(new URL(url), options);
    }
}
