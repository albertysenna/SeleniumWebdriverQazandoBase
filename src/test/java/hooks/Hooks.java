package hooks;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import support.AllureUtils;

public class Hooks {

    @Before
    public void setup() {
        DriverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            AllureUtils.attachScreenshot(scenario);
        }
        DriverFactory.quitDriver();
    }
}