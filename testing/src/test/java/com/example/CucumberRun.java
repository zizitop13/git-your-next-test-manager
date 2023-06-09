package com.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.example",
        features = "classpath:features",
        plugin = "json:target/cucumber-report/report.json"
)
public class CucumberRun {
}
