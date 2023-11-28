package selenium;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;

import static selenium.Screenshot.takeScreenshot;

public class SeleniumTestWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        try {
            takeScreenshot("./screenshots/failed.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
