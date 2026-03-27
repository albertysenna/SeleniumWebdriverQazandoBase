package support;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.Assertions;

public class AssertUtils {

    public static void assertEquals(String description, String expected, String actual) {

        Allure.step(description);

        if (!expected.equals(actual)) {

            String message = description +
                    "\n\nEsperado: " + expected +
                    "\nObtido: " + actual;

            Allure.addAttachment("Diferença encontrada", message);

            throw new AssertionError(message);
        }
    }
}