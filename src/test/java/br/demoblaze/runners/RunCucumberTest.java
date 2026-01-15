package br.demoblaze.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature",
    glue = "br.demoblaze.steps",

    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports.json"
    },

    monochrome = true,
    snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunCucumberTest {
}