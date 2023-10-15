package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Driver;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

public class BurgerMenu {
    @FindBy(id = "react-burger-menu-btn")
    public WebElement BurgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement Logout;

    private WebDriver driver;

    public BurgerMenu() {
        this.driver = Driver.getInstance();
        PageFactory.initElements(this.driver, this);
    }

    public void logout () {
        this.BurgerMenu.click();
        Wait<WebDriver> wait = new WebDriverWait(this.driver, ofSeconds(6));
        wait.until(d -> this.Logout.isDisplayed());
        this.Logout.click();
    }
}
