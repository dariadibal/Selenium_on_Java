package selenium.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public String getURL() {
        return this.driver.getCurrentUrl();
    }
}
