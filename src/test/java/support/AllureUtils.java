package support;

import driver.DriverFactory;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class AllureUtils {

    public static void attachScreenshot(Scenario scenario) {

        byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                .getScreenshotAs(OutputType.BYTES);

        String scenarioName = scenario.getName()
                .replaceAll("[^a-zA-Z0-9]", "_"); // limpa caracteres inválidos

        String uniqueId = UUID.randomUUID().toString().substring(0, 8);

        String fileName = scenarioName + "_" + uniqueId;

        Allure.addAttachment(
                "Screenshot - " + fileName,
                new ByteArrayInputStream(screenshot)
        );
        
    }
}

