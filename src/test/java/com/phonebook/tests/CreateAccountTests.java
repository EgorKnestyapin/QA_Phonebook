package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        // if login link is not present
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            // click on Sign Out button
            click(By.xpath("//button[.='Sign Out']"));
        }
    }

    @Test
    public void createExistedAccountNegativeTest() {
        // click on Login link
        click(By.cssSelector("[href='/login']"));
        // enter email
        type(By.name("email"), "john1@gm.com");
        // enter password
        type(By.name("password"), "Qwerty123$");
        // click on the Registration button
        click(By.name("registration"));
        // assert Sign out button is present
        Assert.assertTrue(isAlertAppears());
    }
}
