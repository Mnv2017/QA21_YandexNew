package com.example.testTask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MarketHeaderHelper extends HelperBase{

    public MarketHeaderHelper(WebDriver driver) {
        super(driver);
    }

    public void searchItemName(String itemName) throws InterruptedException { // typeInSearchInputField
        type(By.id("header-search"), itemName);
        click(By.cssSelector("[data-r='search-button']")); // нажать на кнопку Найти
        Thread.sleep(2000);
    }

    public void selectDepartmentType(String depType) {
        click(By.cssSelector("a[href='/catalog" + depType + "/list?filter-express-delivery=1&searchContext=express']"));
    }

    public void selectExpressDepartment() {
        click(By.xpath("//span[contains(.,'Экспресс')]"));
    }
}
