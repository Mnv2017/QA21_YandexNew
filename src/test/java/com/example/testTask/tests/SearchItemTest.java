package com.example.testTask.tests;

import com.example.testTask.model.Item;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

    @Test
    public void itemTest() throws InterruptedException {
        app.getMainPage().clickToMarketTab();
        app.getMainPage().switchToNexTab(1); //переходим на другую вкладку
        app.getMarketHeader().selectExpressDepartment(); // выбираем раздел Экспресс
        app.getMarketItem().acceptCookies(); // нажимаем Принять
        app.getMarketHeader().selectDepartmentType("--elektronika/23282330"); // выбираем раздел Электроника
        app.getMarketItem().filterItem(new Item().setItemType("--smartfony-i-aksessuary/23282379").setPriceFrom("20000").setPriceTo("35000").setBrand("Apple")); // выбрать раздел Смартфоны, расширенный поиск
        app.getMarketItem().refreshPage(); // обновить страницу
        String itemName = app.getMarketItem().memorizeListElement("2"); // запомнить 2й элемент результата поиска
        app.getMarketHeader().searchItemName(itemName); // в поисковую строку вводим сохраненное значение
        String foundItemName = app.getMarketItem().memorizeListElement("1"); // запоминаем 1й элемент из найденных
        compareItems(itemName, foundItemName); // сравниваем значения
    }
}
