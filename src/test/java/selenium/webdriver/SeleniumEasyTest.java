package selenium.webdriver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import selenium.Cities;

import java.util.List;

import static java.util.stream.Collectors.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumEasyTest {

    private static final List<String> EXPECTED_CITIES = List.of(Cities.TEXAS.name,
            Cities.FLORIDA.name, Cities.NEW_YORK.name);

    private static final String URL = "https://demo.seleniumeasy.com/basic-select-dropdown-demo.html";

    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Test with multiselect")
    public void multiSelectTest() {
        driver.get(URL);
        WebElement selectElement = driver.findElement(By.id("multi-select"));
        Select select = new Select(selectElement);
        select.selectByIndex(Cities.FLORIDA.ordinal());
        select.selectByIndex(Cities.NEW_YORK.ordinal());
        select.selectByIndex(Cities.TEXAS.ordinal());
        List<WebElement> selectedOptions = select.getAllSelectedOptions();
        List<String> names = selectedOptions.stream().map(WebElement::getText).collect(toList());
        assertEquals(EXPECTED_CITIES.size(), names.size(), "Wrong number of selected elements");
        assertTrue(names.containsAll(EXPECTED_CITIES), "Wrong items are selected");
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }
}