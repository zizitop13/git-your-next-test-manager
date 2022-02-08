package ru.zizitop.example.steps;

import io.cucumber.java.After;
import ru.zizitop.example.pages.ShopPages;

public class Hooks {
    @After
    public void refresh() {
        ShopPages.driver.navigate().refresh();
    }
}
