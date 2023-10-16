package selenium.pages;

import org.openqa.selenium.By;
import selenium.Driver;
import selenium.TestUser;

public class LoginPageWithPF extends BasePage {
    private By UsernameInput = By.id("user-name");
    private By PasswordInput = By.id("password");
    private By LoginButton = By.id("login-button");

    private String url = "https://www.saucedemo.com/";

    public LoginPageWithPF () {
        this.driver = Driver.getInstance();
    }

    public void openPage() {
        this.driver.get(this.url);
    }

    public void login (TestUser testUser) {
        this.driver.findElement(UsernameInput).sendKeys(testUser.getUserName());
        this.driver.findElement(PasswordInput).sendKeys(testUser.getPassword());
        this.driver.findElement(LoginButton).click();
    }
}
