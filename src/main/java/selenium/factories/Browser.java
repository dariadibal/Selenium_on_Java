package selenium.factories;

import org.openqa.selenium.remote.AbstractDriverOptions;

public interface Browser {
    public AbstractDriverOptions<?> getOptions();
}