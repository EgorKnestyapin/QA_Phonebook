package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("john1@gm.com")
                .setPassword("Qwerty123$"));
        clickOnLoginButton();
        // assert Sign out is present
        Assert.assertTrue(isSignOutButtonPresent());
    }

    @Test
    public void loginNegativeTestWithoutEmail() {
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setPassword("Qwerty123$"));
        clickOnLoginButton();
        // assert Sign out is present
        Assert.assertTrue(isAlertAppears());
    }
}