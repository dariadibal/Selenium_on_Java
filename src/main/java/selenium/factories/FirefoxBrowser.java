package selenium.factories;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxBrowser implements Browser {
    @Override
    public FirefoxOptions getOptions() {
        return new FirefoxOptions();
    }
}
