package com.amit.pages;

import com.amit.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By successMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterCheckoutDetails(String first, String last, String zip){
        WaitUtils.waitForElementVisible(driver, firstName, 10).sendKeys(first);
        WaitUtils.waitForElementVisible(driver, lastName, 10).sendKeys(last);
        WaitUtils.waitForElementVisible(driver, postalCode, 10).sendKeys(zip);
    }
    public void clickContinue(){
        WaitUtils.waitForElementClickable(driver, continueButton, 10).click();
    }
    public void  clickFinish(){
        WaitUtils.waitForElementClickable(driver, finishButton, 10).click();
    }
    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        ).getText();
    }
}
