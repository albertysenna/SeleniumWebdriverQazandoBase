package runner;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Runner ultra-clean do Cucumber
 *
 * Observações:
 * - Não possui @ConfigurationParameter, todas as configurações ficam em junit-platform.properties
 * - Permite filtros de tags dinâmicos via Maven (-Dcucumber.filter.tags)
 * - Mantém o runner simples e fácil de manter
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // Pasta onde estão as features
public class RunCucumberTest {
}