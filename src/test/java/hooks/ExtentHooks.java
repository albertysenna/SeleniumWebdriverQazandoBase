package hooks;

import com.aventstack.extentreports.*;
import io.cucumber.java.*;
import support.ExtentManager;
import support.ScreenshotUtils;

public class ExtentHooks {

    @Before
    public void before(Scenario scenario) {

        ExtentTest test = ExtentManager
                .getInstance()
                .createTest(scenario.getName());

        ExtentManager.setTest(test);
    }

    @After
    public void after(Scenario scenario) {

        if (scenario.isFailed()) {

            ScreenshotUtils.capture(scenario);

            ExtentManager.getTest().fail("Cenário falhou");

        } else {
            ExtentManager.getTest().pass("Cenário passou");
        }
    }
}