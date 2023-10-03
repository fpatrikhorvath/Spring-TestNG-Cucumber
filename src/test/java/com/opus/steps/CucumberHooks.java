package com.opus.steps;

import com.opus.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberHooks {
    @Before("@ui")
    public void beforeEach() {
        WebDriverFactory.createDriver();
    }

    @After("@ui")
    public void afterEach(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] SCREENSHOT = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(SCREENSHOT, "image/png", "Screenshot.png");
        }
        WebDriverFactory.cleanUpDriver();
    }
}
