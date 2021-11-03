package com.example.testTask.tests;

import com.example.testTask.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    public void compareItems(String itemName, String foundItemName) throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(foundItemName, itemName);
    }

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        app.stop();

    }
}
