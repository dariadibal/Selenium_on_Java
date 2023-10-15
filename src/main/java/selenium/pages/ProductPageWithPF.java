package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Driver;

public class ProductPageWithPF extends BasePage {
    @FindBy (className = "title")
    private WebElement Title;

    public ProductPageWithPF () {
        this.driver = Driver.getInstance();
        PageFactory.initElements(this.driver, this);
    }

    public String getTitle() {
        return this.Title.getText();
    }
}
