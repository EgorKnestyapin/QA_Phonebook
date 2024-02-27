package com.phonebook.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;
import java.util.List;

public class TestBase {
    static WebDriver webDriver;

    //    @BeforeMethod
    @BeforeSuite
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("https://telranedu.web.app");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    //    @AfterMethod
    @AfterSuite
    public void tearDown() {
        webDriver.quit();
    }

    public boolean isElementPresent(By locator) {
        return !webDriver.findElements(locator).isEmpty();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            webDriver.findElement(locator).clear();
            webDriver.findElement(locator).sendKeys(text);
        }
    }

    public void click(By locator) {
        webDriver.findElement(locator).click();
    }

    public boolean isAlertAppears() {
        Alert alert = new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            alert.accept();
            return true;
        }
    }

    public void clickOnSignOutButton() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillLoginRegisterForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
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

    public boolean isHomeComponentPresent() {
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h1"));
    }
}
