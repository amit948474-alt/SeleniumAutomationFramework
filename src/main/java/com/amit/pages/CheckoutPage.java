package com.amit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(firstName).sendKeys(first);
        driver.findElement(lastName).sendKeys(last);
        driver.findElement(postalCode).sendKeys(zip);
    }
    public void clickContinue(){
        driver.findElement(continueButton).click();
    }
    public void  clickFinish(){
        driver.findElement(finishButton).click();
    }
    public String getSuccessMessage(){
        return driver.findElement(successMessage).getText();
    }
}
