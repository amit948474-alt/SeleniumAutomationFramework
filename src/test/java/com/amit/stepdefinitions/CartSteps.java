package com.amit.stepdefinitions;

import com.amit.pages.CartPage;
import com.amit.pages.CheckoutPage;
import com.amit.pages.LoginPage;
import com.amit.pages.ProductsPage;
import com.amit.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartSteps {
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ProductsPage productsPage;

    @Given("user is logged into the SauceDemo")
    public void userIsLoggedInToSauceDemo() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
    }
    @Then("user have added a product to the cart")
    public void userHasAddedAProductToTheCart() {
        productsPage = new ProductsPage(Hooks.driver);
        productsPage.addProductToCart();
    }
    @Then("user opens cart")
    public void userOpensTheCart() {
        productsPage = new ProductsPage(Hooks.driver);
        productsPage.openCart();
    }
    @When("cart has a value > 0")
    public void cartHasAValueGreaterThanZero() {
        productsPage.getCartCount();
        Assert.assertTrue(productsPage.getCartCount()>0);
    }
    @Then("user logsout")
    public void userLogsout() {
        productsPage.logout();
    }
}

