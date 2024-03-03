package com.phonebook.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseHelper {
    public BaseHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    WebDriver webDriver;
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

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String takeScreenshot() {
        File tmp = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("screenshots/screen_" + System.currentTimeMillis() + ".png");

        try {
            Files.copy(tmp,screenshot);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return screenshot.getAbsolutePath();
    }
}
