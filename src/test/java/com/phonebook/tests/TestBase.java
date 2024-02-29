package com.phonebook.tests;

import com.phonebook.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public final ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    //    @BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //    @AfterMethod
    @AfterSuite
    public void tearDown() {
        app.stop();
    }
}
