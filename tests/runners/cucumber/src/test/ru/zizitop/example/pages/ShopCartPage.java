package ru.zizitop.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.id;

public class ShopCartPage {

    @FindBy(xpath = "//*[contains(@id, 'total-counters')]")
    private WebElement totalCounters;
    public final WebDriver driver;

    public ShopCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int getTotalCountersNumber() {
        return Integer.parseInt(totalCounters.getText());
    }

    public void plusItemButton(int itemId) {
        driver.findElement(id("btn-plus-"+itemId)).click();
    }

    public void minusItemButton(int itemId) {
        driver.findElement(id("btn-minus-"+itemId)).click();
    }

    public void trashItemButton(int itemId) {
        driver.findElement(id("btn-trash-"+itemId)).click();
    }

    public String getItemNumber(int itemId) {
        return driver.findElement(id("item-counter-"+itemId))
                .getText();
    }
}
