package selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static java.time.Duration.ofSeconds;
import static selenium.Screenshot.takeScreenshot;

public class BurgerMenu extends BasePage {
    private final By burgerMenu = By.id("react-burger-menu-btn");

    private final By logoutLink = By.id("logout_sidebar_link");

    public BurgerMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Logout")
    public LoginPageWithPF logout() throws IOException {
        this.driver.findElement(this.burgerMenu).click();
        Wait<WebDriver> wait = new WebDriverWait(this.driver, ofSeconds(6));
        wait.until(d -> this.driver.findElement(this.logoutLink).isDisplayed());
        takeScreenshot("./screenshots/LeftSideMenu.png");
        this.driver.findElement(this.logoutLink).click();
        return new LoginPageWithPF(this.driver);
    }
}
