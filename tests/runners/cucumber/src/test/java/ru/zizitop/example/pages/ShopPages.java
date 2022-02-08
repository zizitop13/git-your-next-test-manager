package ru.zizitop.example.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ShopPages {

    private ShopPages() {
    }

    public static WebDriverManager wdm;

    public static WebDriver driver;

    static {
        var host = "localhost";
        var env = System.getenv("ENV");
        wdm = WebDriverManager.chromedriver();
        if (env != null && env.equals("CI")) {
            host = "host.docker.internal";
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
