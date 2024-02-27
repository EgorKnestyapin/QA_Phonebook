package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase {
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
    }


    @Test
    public void removeContactTest() {
        int sizeBefore = sizeOfContacts();
        removeContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        // assert Contact is deleted by size
        Assert.assertEquals(sizeBefore - 1, sizeAfter);
    }

}
