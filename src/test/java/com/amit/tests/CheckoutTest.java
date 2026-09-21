package com.amit.tests;

import com.amit.base.BaseTest;
import com.amit.pages.CartPage;
import com.amit.pages.CheckoutPage;
import com.amit.pages.LoginPage;
import com.amit.pages.ProductsPage;
import com.amit.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckoutTest extends BaseTest {

    @Test(groups = "regression")
    public void checkoutTest(){
        LoginPage loginPage = new LoginPage (driver);
        CartPage cartPage = new CartPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
        productsPage.addProductToCart();
         productsPage.openCart();

        cartPage.clickCheckout();
        checkoutPage.enterCheckoutDetails("Amit", "Kumar", "110020");
        checkoutPage.clickContinue();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));

        checkoutPage.clickFinish();

        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!"
        );

    }

}
