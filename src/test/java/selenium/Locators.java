package selenium;

import org.openqa.selenium.By;

public class Locators {
    public final static By USER_NAME_INPUT_LOCATOR = By.xpath("//input[@id='user-name']");
    public final static By PASSWORD_INPUT_LOCATOR = By.id("password");
    public final static By LOGIN_BUTTON_LOCATOR = By.cssSelector("#login-button");
    public final static By PRODUCT_PAGE_TITLE_LOCATOR = By.className("title");
    public final static By LOGIN_FORM_LOCATOR = By.tagName("form");
    //The following locators could be found on Products page
    public final static By ADD_TO_CART_SAUCE_LABS_BACKPACK_LOCATOR = By.name("add-to-cart-sauce-labs-backpack");
    public final static By LABS_BACKPACK_PRODUCT_LINK_LOCATOR = By.partialLinkText("Backpack");
    public final static By SAUCE_LABS_BIKE_LIGHT_LINK_LOCATOR = By.linkText("Sauce Labs Bike Light");
}