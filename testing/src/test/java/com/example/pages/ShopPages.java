package com.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.time.Duration;

public class ShopPages {

    private ShopPages() {
    }

    public static WebDriverManager wdm;

    public static WebDriver driver;

    static {
        String host = null;
        try {
            host = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        var env = System.getenv("ENV");
        wdm = WebDriverManager.chromedriver();
        if (env != null && env.equals("CI")) {
            wdm = wdm.browserInDocker();
        }
        driver = wdm.create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://" + host + ":3000/");
        shopCartPage = new ShopCartPage(driver);
    }

    public static ShopCartPage shopCartPage;


}
