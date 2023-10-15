package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Driver;

public class ProductPageWithPF extends BasePage {
    @FindBy(className = "title")
    private WebElement title;

    public ProductPageWithPF(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return this.title.getText();
    }
}
