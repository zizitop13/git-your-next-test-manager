package com.example.steps;

import com.example.pages.ShopPages;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

public class ItemStepdefs {

    @Тогда("^количество наименований в корзине равно (\\d+)$")
    public void assertTotalItemsAmountEquals(int number) {
        int totalCountersNumber = ShopPages.shopCartPage.getTotalItemsAmount();
        Assert.assertEquals(number, totalCountersNumber);
    }

    @Если("пользователь нажмет на кнопку плюс для {int}-го наименования")
    public void plusItem(int itemId) {
        ShopPages.shopCartPage.clickOnPlusItemButton(itemId);
    }

    @Если("пользователь нажмет на кнопку минус для {int}-го наименования")
    public void minusItem(int itemId) {
        ShopPages.shopCartPage.clickOnMinusItemButton(itemId);
    }

    @Если("пользователь нажмет на кнопку удалить для {int}-го наименования")
    public void removeItem(int itemId) {
        ShopPages.shopCartPage.clickOnTrashItemButton(itemId);
    }

    @Тогда("количество единиц {int}-го наименования равно {int}")
    public void assertItemAmountEquals(int itemId, int number) {
        String itemNumber = ShopPages.shopCartPage.getItemAmount(itemId);
        if(number > 0) {
            Assert.assertEquals(number, Integer.parseInt(itemNumber));
        } else {
            Assert.assertEquals("Zero", itemNumber);
        }
    }
}
