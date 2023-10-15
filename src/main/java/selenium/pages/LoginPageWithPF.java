package selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import selenium.Driver;
import selenium.TestUser;

public class LoginPageWithPF extends BasePage {
    @FindBy(id = "user-name")
    private WebElement UsernameInput;
    @FindBy(id = "password")
    private WebElement PasswordInput;
    @FindBy (id = "login-button")
    private WebElement LoginButton;

    private String url = "https://www.saucedemo.com/";

    public LoginPageWithPF () {
        this.driver = Driver.getInstance();
        PageFactory.initElements(this.driver, this);
    }

    public void openPage() {
        this.driver.get(this.url);
    }

    public void login (TestUser testUser) {
        this.UsernameInput.sendKeys(testUser.getUserName());
        this.PasswordInput.sendKeys(testUser.getPassword());
        this.LoginButton.click();
    }
}
