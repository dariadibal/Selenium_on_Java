package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void takeScreenshot(String pathname) throws IOException {
        WebDriver driver = Driver.getInstance().getDriver();
        File src = ((TakesScreenshot) driver ).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File(pathname));
    }
}
