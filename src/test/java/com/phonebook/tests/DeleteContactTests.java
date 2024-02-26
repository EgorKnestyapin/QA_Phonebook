package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
    // precondition
    @BeforeMethod
    public void precondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            click(By.xpath("//button[.='Sign Out']"));
        }
        click(By.cssSelector("[href='/login']"));
        type(By.name("email"), "john1@gm.com");
        type(By.name("password"), "Qwerty123$");
        click(By.name("login"));
        click(By.cssSelector("[href='/add']"));
        type(By.cssSelector("input:nth-child(1)"), "Karl");
        type(By.cssSelector("input:nth-child(2)"), "Adam");
        type(By.cssSelector("input:nth-child(3)"), "1234567890");
        type(By.cssSelector("input:nth-child(4)"), "adam@gm.com");
        type(By.cssSelector("input:nth-child(5)"), "Berlin");
        type(By.cssSelector("input:nth-child(6)"), "goalkeeper");
        click(By.cssSelector(".add_form__2rsm2 button"));
    }


    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();
        // click on the card
        click(By.cssSelector(".contact-item_card__2SOIM"));
        // click on the Remove button
        click(By.xpath("//button[.='Remove']"));
        pause(1000);
        int sizeAfter = sizeOfContacts();
        // assert Contact is deleted by size
        Assert.assertEquals(sizeBefore - 1, sizeAfter);
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return webDriver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
