package com.phonebook.fw;

import com.phonebook.models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnSaveButton() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public void fillContactForm(Contact contact) {
        // enter name
        type(By.cssSelector("input:nth-child(1)"), contact.getName());
        // enter lastname
        type(By.cssSelector("input:nth-child(2)"), contact.getLastName());
        // enter phone
        type(By.cssSelector("input:nth-child(3)"), contact.getPhoneNumber());
        // enter email
        type(By.cssSelector("input:nth-child(4)"), contact.getEmail());
        // enter address
        type(By.cssSelector("input:nth-child(5)"), contact.getEmail());
        // enter description
        type(By.cssSelector("input:nth-child(6)"), contact.getDescription());
    }

    public void clickOnAddLink() {
        click(By.cssSelector("[href='/add']"));
    }

    public void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[.='Remove']"));
    }

    public boolean isContactCreatedByText(String text) {
        List<WebElement> contacts = webDriver.findElements(By.cssSelector("h2"));
        for (WebElement element : contacts) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public int sizeOfContacts() {
        if (isElementPresent(By.cssSelector(".contact-item_card__2SOIM"))) {
            return webDriver.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
        }
        return 0;
    }
}
