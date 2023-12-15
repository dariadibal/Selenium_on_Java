package selenium.factories;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser implements Browser{
    @Override
    public ChromeOptions getOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        return chromeOptions;
    }
}
