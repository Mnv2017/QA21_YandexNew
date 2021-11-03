package com.example.testTask.fw;

import com.example.testTask.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MarketItemHelper extends HelperBase {

    public MarketItemHelper(WebDriver driver) {
        super(driver);
    }

    public String memorizeListElement(String elNumber) { // getItemNameFromListByOrder
        return driver.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][" + elNumber + "]//h3")).getText();
    }

    public void filterItem(Item item) throws InterruptedException {
        click(By.cssSelector("a[href='/catalog" + item.getItemType() + "/list?onstock=1&how=dpop&cvredirect=3&track=srch_ddl']"));
        //спускаемся вниз
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(1000);
        // задаем расширенный поиск
        type(By.id("glpricefrom"), item.getPriceFrom());
        type(By.id("glpriceto"), item.getPriceTo());

        click(By.xpath("//span[text()='" + item.getBrand() + "']"));
    }
}
