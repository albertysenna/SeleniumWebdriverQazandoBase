package support;


import io.cucumber.java.Scenario;

public class ScenarioContext {
    private static ThreadLocal<Scenario> scenario = new ThreadLocal<>();

    public static void setScenario(Scenario sc) {
        scenario.set(sc);
    }

    public static Scenario getScenario() {
        return scenario.get();
    }
}