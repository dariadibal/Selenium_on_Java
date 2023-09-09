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
import selenium.EmployeeUser;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersTableTest {

    private static final String URL = "https://demo.seleniumeasy.com/table-sort-search-demo.html";
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-ssl-errors=yes", "--ignore-certificate-errors");
        driver = new ChromeDriver(options);
    }

    @Test
    @DisplayName("Returns list of custom objects")
    public void getEmployeesTest() {
        driver.get(URL);
        WebElement selectElement = driver.findElement(By.cssSelector("select[name='example_length']"));
        Select select = new Select(selectElement);
        select.selectByIndex(0);
        List<EmployeeUser> users = getUsers(40, 200000);
        assertEquals(8, users.size(), "Wrong number of necessary users");
    }

    private List <EmployeeUser> getUsers (int ageLimit, int salaryLimit) {
        List<EmployeeUser> users = new ArrayList<>();
        int numberOfPages = driver.findElements(By.cssSelector("span .paginate_button")).size();
        while (numberOfPages != 0) {
            List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr[role='row']"));
            for (WebElement row : rows) {
                List<WebElement> columns = row.findElements(By.cssSelector("td"));
                int age = Integer.parseInt(columns.get(3).getText());
                int salary = Integer.parseInt(columns.get(5).getAttribute("data-order"));
                if (age > ageLimit && salaryLimit <= salary) {
                    EmployeeUser temp = new EmployeeUser(
                            columns.get(0).getText(),
                            columns.get(1).getText(),
                            columns.get(2).getText());
                    users.add(temp);
                }
            }
            driver.findElement(By.id("example_next")).click();
            numberOfPages--;
        }
        return users;
    }

    @AfterEach
    public void cleanup() {
        driver.quit();
    }
}
