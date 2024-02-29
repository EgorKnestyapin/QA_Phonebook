package com.phonebook.tests;

import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase {
    // precondition
    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail("john1@gm.com")
                .setPassword("Qwerty123$"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest() {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(
                new Contact()
                        .setName("Adam")
                        .setLastName("Karl")
                        .setPhoneNumber("1234567890")
                        .setEmail("adam@gm.com")
                        .setAddress("Berlin")
                        .setDescription("goalkeeper")
        );
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreatedByText("Adam"));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }
}
