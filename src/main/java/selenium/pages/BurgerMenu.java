package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class BurgerMenu extends BasePage {
    @FindBy(id = "react-burger-menu-btn")
    public WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    public BurgerMenu(WebDriver driver) {
        super(driver);
    }

    public LoginPageWithPF logout() {
        this.burgerMenu.click();
        Wait<WebDriver> wait = new WebDriverWait(this.driver, ofSeconds(6));
        wait.until(d -> this.logoutLink.isDisplayed());
        this.logoutLink.click();
        return new LoginPageWithPF(this.driver);
    }
}
