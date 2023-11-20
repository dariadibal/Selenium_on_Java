package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageWithPF extends BasePage {
    private final By title = By.className("title");

    public ProductPageWithPF(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.driver.findElement(this.title).getText();
    }
}
