package selenium.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.TestUser;

public class LoginPageWithPF extends BasePage {
    private final By usernameInput = By.id("user-name");

    private final By passwordInput = By.id("password");

    private final By loginButton = By.id("login-button");

    public LoginPageWithPF(WebDriver driver) {
        super(driver);
    }

    @Step("Login")
    public ProductPageWithPF login(TestUser testUser) {
        this.driver.findElement(this.usernameInput).sendKeys(testUser.getUserName());
        this.driver.findElement(this.passwordInput).sendKeys(testUser.getPassword());
        this.driver.findElement(this.loginButton).click();
        return new ProductPageWithPF(this.driver);
    }
}
