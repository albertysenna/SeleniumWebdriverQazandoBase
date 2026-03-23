package support;

import com.aventstack.extentreports.MediaEntityBuilder;
import driver.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import support.ExtentManager;
import java.util.Base64;

public class ScreenshotUtils {

    public static void capture(Scenario scenario){

        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        // Cucumber
        String nome = scenario.getName() + " - " + System.currentTimeMillis();
        scenario.attach(screenshot, "image/png", nome);

        // Extent
        String base64 = Base64.getEncoder().encodeToString(screenshot);

        ExtentManager.getTest().info("Screenshot",
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }
}
