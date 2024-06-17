package com.taskCompletion.TestRunner;

import com.taskCompletion.CommonLibrary.HealthCheck;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:build/reports/CucumberSpecificReport/Cucumbertestreport.html"
                , "json:build/reports/CucumberSpecificReport/CucumberJson/cucumber.json"
        },
        features = {"src/test/resources/FeatureFiles/"},
        glue = {"com/taskCompletion/StepDefinitions"},
        tags = "@P0_check_todos_completion",
        monochrome = true
)


public class TestRunner_API_Task_Completion {

    @BeforeClass()
    public static void HealthCheckForAPI() {
        HealthCheck health = new HealthCheck();
        health.HealthCheck();
    }


}
