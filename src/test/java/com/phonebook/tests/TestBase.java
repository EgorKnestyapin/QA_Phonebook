package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class TestBase {
    static WebDriver webDriver;

//    @BeforeMethod
    @BeforeSuite
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://telranedu.web.app");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

//    @AfterMethod
    @AfterSuite
    public void tearDown() {
        webDriver.quit();
    }

    public boolean isElementPresent(By locator) {
        return !webDriver.findElements(locator).isEmpty();
    }

    public void type(By locator, String text) {
        click(locator);
        webDriver.findElement(locator).clear();
        webDriver.findElement(locator).sendKeys(text);
    }

    public void click(By locator) {
        webDriver.findElement(locator).click();
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            alert.accept();
            return true;
        }
    }
}
