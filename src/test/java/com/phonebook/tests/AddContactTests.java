package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    // precondition
    @BeforeMethod
    public void precondition() {
        if (!isLoginLinkPresent()) {
            clickOnSignOutButton();
        }
        clickOnLoginLink();
        fillLoginRegisterForm(new User()
                .setEmail("john1@gm.com")
                .setPassword("Qwerty123$"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        clickOnAddLink();
        fillContactForm(
                new Contact()
                        .setName("Adam")
                        .setLastName("Karl")
                        .setPhoneNumber("1234567890")
                        .setEmail("adam@gm.com")
                        .setAddress("Berlin")
                        .setDescription("goalkeeper")
        );
        clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(isContactCreatedByText("Adam"));
    }

    @AfterMethod
    public void postCondition() {
        removeContact();
    }
}
