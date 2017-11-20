package configuration;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.slf4j.MDC;
import steps.BaseSteps;

/**
 * Created by User on 15.02.2017.
 */
public class CucumberHooks extends BaseSteps {


    @After
    public void afterFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            allureAttachments.attachScreenshot();
        }
    }

    @Before
    public void logInfo(Scenario scenario) {
        MDC.put("scenarioName", scenario.getName());
    }

}
