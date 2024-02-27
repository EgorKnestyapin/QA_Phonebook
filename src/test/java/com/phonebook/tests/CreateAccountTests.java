package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void createExistedAccountNegativeTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("john1@gm.com")
                .setPassword("Qwerty123$"));
        clickOnRegistrationButton();
        // assert Sign out button is present
        Assert.assertTrue(isAlertAppears());
    }
}
