package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHomePage().isHomeComponentPresent()) {
            clickOnHomeLink();
        }
    }

    private void clickOnHomeLink() {
        app.getHomePage().clickOnHomeLink();
    }

    @Test
    public void isHomeComponentPresentTest() {
//        System.out.println("Home component is " + isHomeComponentPresent());
        Assert.assertTrue(app.getHomePage().isHomeComponentPresent());
    }
}
