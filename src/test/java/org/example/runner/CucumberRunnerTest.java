package org.example.runner;

import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.example.stepdefinitions",
        plugin = {"pretty"},
        tags = "@CP1_login"
)
public class CucumberRunnerTest {
}
