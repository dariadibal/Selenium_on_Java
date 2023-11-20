package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class BurgerMenu extends BasePage {
    private final By burgerMenu = By.id("react-burger-menu-btn");

    private final By logoutLink = By.id("logout_sidebar_link");

    public BurgerMenu(WebDriver driver) {
        super(driver);
    }

    public LoginPageWithPF logout() {
        this.driver.findElement(this.burgerMenu).click();
        Wait<WebDriver> wait = new WebDriverWait(this.driver, ofSeconds(6));
        wait.until(d -> this.driver.findElement(this.logoutLink).isDisplayed());
        this.driver.findElement(this.logoutLink).click();
        return new LoginPageWithPF(this.driver);
    }
}
