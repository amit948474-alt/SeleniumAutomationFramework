package com.amit.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static WebElement waitForElementClickable(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static WebElement waitForElementVisible(WebDriver driver, By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static Boolean waitForInvisibilityOfElement(WebDriver driver,By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));

        return  wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}