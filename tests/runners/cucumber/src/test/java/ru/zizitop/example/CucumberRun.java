package ru.zizitop.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "ru.zizitop.example.steps",
        features = "classpath:features/cart",
        plugin = { "pretty", "html:target/cucumber-reports.html" }

)
public class CucumberRun {
}
