package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }
    }

    @Test
    public void loginPositiveTest() {
        // click on Login link
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.name("email"), "john1@gm.com");
        // enter password
        type(By.name("password"), "Qwerty123$");
        // click on the Login button
        click(By.name("login"));
        // assert Sign out is present
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }
}
