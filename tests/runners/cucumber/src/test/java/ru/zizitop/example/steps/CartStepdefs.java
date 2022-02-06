package ru.zizitop.example.steps;

import io.cucumber.java.ru.Затем;
import static ru.zizitop.example.pages.ShopPages.shopCartPage;

public class CartStepdefs {

    @Затем("пользователь нажмет на кнопку \"сбросить\"")
    public void refreshCart() {
        shopCartPage.clickOnRefreshCartButton();
    }
}
