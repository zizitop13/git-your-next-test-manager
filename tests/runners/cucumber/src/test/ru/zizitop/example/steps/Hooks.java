package ru.zizitop.example.steps;

import io.cucumber.java.After;

import static ru.zizitop.example.pages.Pages.shopCartPage;

public class Hooks {
    @After
    public void refresh() {
        shopCartPage.driver.navigate().refresh();
    }
}
