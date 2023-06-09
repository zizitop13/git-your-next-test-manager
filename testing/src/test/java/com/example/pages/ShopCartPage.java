package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.id;

public class ShopCartPage {

    public final WebDriver driver;

    @FindBy(xpath = "//*[contains(@id, 'total-counters')]")
    private WebElement totalCounters;
    @FindBy(xpath = "//*[contains(@id, 'refresh-cart')]")
    private WebElement  refreshCart;

    public ShopCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getTotalItemsAmount() {
        return Integer.parseInt(totalCounters.getText());
    }

    public String getItemAmount(int itemId) {
        return driver.findElement(id("item-counter-"+itemId))
                .getText();
    }

    public void clickOnPlusItemButton(int itemId) {
        driver.findElement(id("btn-plus-"+itemId))
                .click();
    }

    public void clickOnMinusItemButton(int itemId) {
        driver.findElement(id("btn-minus-"+itemId))
                .click();
    }

    public void clickOnTrashItemButton(int itemId) {
        driver.findElement(id("btn-trash-"+itemId))
                .click();
    }


    public void clickOnRefreshCartButton() {
        refreshCart.click();
    }
}
