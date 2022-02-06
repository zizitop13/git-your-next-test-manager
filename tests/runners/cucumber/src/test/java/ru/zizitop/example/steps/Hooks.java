package ru.zizitop.example.steps;

import io.cucumber.java.After;

import static ru.zizitop.example.pages.ShopPages.shopCartPage;

public class Hooks {
    @After
    public void refresh() {
        shopCartPage.driver.navigate().refresh();
    }
}
