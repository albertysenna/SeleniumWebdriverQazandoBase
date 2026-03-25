package support;

import driver.DriverFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Commands {

    public static void waitElementBeClickable(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitElementBeVisible(By element, Integer tempo) {
        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    public static void clickElement(By element) {

        System.out.println("######################");


        System.out.println("Vai clicar no elemento: " + element);

        waitElementBeClickable(element, 10);
        DriverFactory.getDriver().findElement(element).click();

        System.out.println("Clicou no elemento " + element);


//            System.out.println("********** Aconteceu um erro ao tentar clicar no elemento: " + element);
//            System.out.println(error);

    }


    public static void fillField(By element, String value) {


        System.out.println("Vai preencher o campo: " + element);

        waitElementBeVisible(element, 10);
        DriverFactory.getDriver().findElement(element).sendKeys(value);

        System.out.println("Preencheu o campo " + element);


//            System.out.println("********** Aconteceu um erro ao tentar preencher o campo: " + element);
//            System.out.println(error);

    }


    public static void checkMessage(By element, String expectedMessage) {


        System.out.println("################################################");
        System.out.println("Vai validar mensagem: " + expectedMessage);

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

        String actualMessage = DriverFactory.getDriver().findElement(element).getText();

        Assertions.assertEquals( expectedMessage, actualMessage, "Os textos não são iguais!");

//        Assertions.assertEquals(
//                expectedMessage, actualMessage,
//                "Esperado: '" + expectedMessage + "' mas veio: '" + actualMessage + "'"
//        );

        System.out.println("Validou a mensagem: " + expectedMessage);
        System.out.println("#################################################");
    }


}



