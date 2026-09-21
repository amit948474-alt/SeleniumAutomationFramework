package com.amit.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@sanity",
        features = "src/test/resources/features",
        glue = "com.amit.stepdefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {

}