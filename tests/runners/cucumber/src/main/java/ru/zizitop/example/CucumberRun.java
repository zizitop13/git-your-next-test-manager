package ru.zizitop.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "ru.zizitop.example.steps",
        features = "file:../../features"
)
public class CucumberRun {
}
