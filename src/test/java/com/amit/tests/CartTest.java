package com.amit.tests;

import com.amit.base.BaseTest;
import com.amit.pages.CartPage;
import com.amit.pages.LoginPage;
import com.amit.pages.ProductsPage;
import com.amit.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest  {
    @Test(groups = "sanity")
    public void addProductToCartTest(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
        productsPage.addProductToCart();
        int itemCount = productsPage.getCartCount();
        Assert.assertTrue(itemCount>0);
        productsPage.openCart();
        cartPage.clickCheckout();

    }
}
