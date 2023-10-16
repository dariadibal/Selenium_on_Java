package selenium.pages;

import org.openqa.selenium.By;
import selenium.Driver;

public class ProductPageWithPF extends BasePage {

    private By Title = By.className("title");

    public ProductPageWithPF () {
        this.driver = Driver.getInstance();
    }

    public String getTitle() {
        return this.driver.findElement(Title).getText();
    }
}
