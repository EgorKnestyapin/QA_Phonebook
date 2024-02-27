package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isHomeComponentPresent()) {
            clickOnHomeLink();
        }
    }

    private void clickOnHomeLink() {
        click(By.cssSelector("[href='/home']"));
    }

    @Test
    public void isHomeComponentPresentTest() {
//        System.out.println("Home component is " + isHomeComponentPresent());
        Assert.assertTrue(isHomeComponentPresent());
    }
}
