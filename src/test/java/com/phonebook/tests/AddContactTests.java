package com.phonebook.tests;

import com.phonebook.fw.DataProviders;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Test(dataProvider = "addContact", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProvider(String name, String lastname, String phone, String email,
                                                       String address, String description) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(
                new Contact()
                        .setName(name)
                        .setLastName(lastname)
                        .setPhoneNumber(phone)
                        .setEmail(email)
                        .setAddress(address)
                        .setDescription(description)
        );
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreatedByText(name));
    }


    @Test(dataProvider = "addContactFromCSV", dataProviderClass = DataProviders.class)
    public void addContactPositiveTestFromDataProviderWithFile(Contact contact) {
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(contact);
        app.getContact().clickOnSaveButton();
        // assert Contact is added by text
        Assert.assertTrue(app.getContact().isContactCreatedByText(contact.getName()));
    }
}
