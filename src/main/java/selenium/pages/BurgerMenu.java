package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.Driver;

import static java.time.Duration.ofSeconds;

public class BurgerMenu {
    private By BurgerMenuIcon = By.id("react-burger-menu-btn");

    private By Logout = By.id("logout_sidebar_link");

    private WebDriver driver;

    public BurgerMenu() {
        this.driver = Driver.getInstance();
    }

    public void logout () {
        this.driver.findElement(BurgerMenuIcon).click();
        Wait<WebDriver> wait = new WebDriverWait(this.driver, ofSeconds(6));
        wait.until(d -> this.driver.findElement(Logout).isDisplayed());
        this.driver.findElement(Logout).click();
    }
}
