package com.example.steps;

import com.example.pages.ShopPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.Assume;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        skipNonAutomated(scenario);
    }

    @After
    public void refresh(Scenario scenario) {
        skipNonAutomated(scenario);
        ShopPages.driver.navigate().refresh();
    }

    private static void skipNonAutomated(Scenario scenario) {
        boolean automated = scenario.getSourceTagNames().contains("@automated");
        Assume.assumeTrue("Skip due to scenario was not automated yet", automated);
    }
}
