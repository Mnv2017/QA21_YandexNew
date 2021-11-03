package com.example.testTask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void refreshPage() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(1000);
    }

    public void acceptCookies() {
        click(By.cssSelector("[data-id='button-all']"));
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void switchToNexTab(int number) {
        List<String> availableWindows = new ArrayList<>(driver.getWindowHandles()); // метод отвечает за перебор окон
        if (!availableWindows.isEmpty()) {
            driver.switchTo().window(availableWindows.get(number)); // первое окно = 0, окно с Маркет = 1
        }
    }


}
