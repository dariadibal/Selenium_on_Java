package selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPageWithPF extends BasePage {
    private final By title = By.className("title");

    public ProductPageWithPF(WebDriver driver) {
        super(driver);
    }

    @Step("Get Title")
    public String getTitle() {
        return this.driver.findElement(this.title).getText();
    }
}
