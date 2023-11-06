package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Properties;
import selenium.TestUser;

public class LoginPageWithPF extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPageWithPF(WebDriver driver) {
        super(driver);
    }

    public ProductPageWithPF login(TestUser testUser) {
        this.usernameInput.sendKeys(testUser.getUserName());
        this.passwordInput.sendKeys(testUser.getPassword());
        this.loginButton.click();
        return new ProductPageWithPF(this.driver);
    }
}
