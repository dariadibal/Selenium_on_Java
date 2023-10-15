package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.Driver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public String getURL() {
        return this.driver.getCurrentUrl();
    }
}
