package com.example.steps;

import com.example.pages.ShopPages;
import io.cucumber.java.ru.Затем;

public class CartStepdefs {

    @Затем("пользователь нажмет на кнопку сбросить")
    public void refreshCart() {
        ShopPages.shopCartPage.clickOnRefreshCartButton();
    }
}
