package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {

    @Test
    public void createExistedAccountNegativeTest() {
        // click on Login link
        webDriver.findElement(By.cssSelector("[href='/login']")).click();
        // enter email
        webDriver.findElement(By.name("email")).click();
        webDriver.findElement(By.name("email")).clear();
        webDriver.findElement(By.name("email")).sendKeys("john1@gm.com");
        // enter password
        webDriver.findElement(By.name("password")).click();
        webDriver.findElement(By.name("password")).clear();
        webDriver.findElement(By.name("password")).sendKeys("Qwerty123$");
        // click on the Registration button
        webDriver.findElement(By.name("registration")).click();
        // assert Sign out button is present
        Assert.assertTrue(isAlertAppears());
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
        return alert != null;
    }
}
