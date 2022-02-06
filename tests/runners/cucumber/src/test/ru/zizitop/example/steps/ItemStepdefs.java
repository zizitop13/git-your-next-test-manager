package ru.zizitop.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

import static ru.zizitop.example.pages.Pages.shopCartPage;

public class ItemStepdefs {


    @Тогда("^количество наименований в корзине равно (\\d+)$")
    public void assertTotalCartNumberEquals(int number) {
        int totalCountersNumber = shopCartPage.getTotalCountersNumber();
        Assert.assertEquals(number, totalCountersNumber);
    }

    @Если("пользователь нажмет на кнопку \"плюс\" для {int}-го наименования")
    public void pushButtonForItem(int itemId) {
        shopCartPage.plusItemButton(itemId);
    }

    @Если("пользователь нажмет на кнопку \"минус\" для {int}-го наименования")
    public void minusButtonForItem(int itemId) {
        shopCartPage.minusItemButton(itemId);
    }

    @Если("пользователь нажмет на кнопку \"удалить\" для {int}-го наименования")
    public void trashButtonForItem(int itemId) {
        shopCartPage.trashItemButton(itemId);
    }

    @Тогда("количество единиц {int}-го наименования равно {int}")
    public void assertItemNumberEquals(int itemId, int number) {
        String itemNumber = shopCartPage.getItemNumber(itemId);
        if(number > 0) {
            Assert.assertEquals(number, Integer.parseInt(itemNumber));
        } else {
            Assert.assertEquals("Zero", itemNumber);
        }
    }

    @After
    public void refresh() {
        shopCartPage.driver.navigate().refresh();
    }
}
