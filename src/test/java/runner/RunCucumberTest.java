package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")

@ConfigurationParameter(
        key = GLUE_PROPERTY_NAME,
        value = "steps,hooks"
)


@ConfigurationParameter(
        key = FILTER_TAGS_PROPERTY_NAME,
        value = "@login-sucesso"
)

@ConfigurationParameter(
        key = PLUGIN_PROPERTY_NAME,
        value = "pretty,io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm,html:target/cucumber-report.html"
)

@ConfigurationParameter(
        key = PLUGIN_PUBLISH_QUIET_PROPERTY_NAME,
        value = "true"
)

public class RunCucumberTest {
}