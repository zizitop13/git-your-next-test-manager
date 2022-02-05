package ru.zizitop.example.steps;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;

import static ru.zizitop.example.pages.Pages.shopCartPage;

public class ItemStepdefs {

    @Если("^пользователь нажимает на кнопку \"добавить\" для (\\d+)-го наименования$")
    public void pushAddButtonFor(int itemId) {
        shopCartPage.addItem(itemId);
    }

    @Тогда("^количество наименований в корзине равно (\\d+)$")
    public void itemNumberIs(int number) {
        int totalCountersNumber = shopCartPage.getTotalCountersNumber();
        Assert.assertEquals(number, totalCountersNumber);
    }
}
