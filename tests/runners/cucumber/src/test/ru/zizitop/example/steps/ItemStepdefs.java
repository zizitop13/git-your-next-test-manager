package ru.zizitop.example.steps;

import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Тогда;

public class ItemStepdefs {

    @Если("^пользователь нажимает на кнопку \"добавить\" для (\\d+)-го наименования$")
    public void pushAddButtonFor(int itemNumber) {
    }

    @Тогда("^количество наименований в корзине равно (\\d+)$")
    public void itemNumberIs(int number) {
    }
}
