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

public class CheckoutSteps {
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ProductsPage productsPage;

    @Given("user is logged into SauceDemo")
    public void userIsLoggedIntoSauceDemo() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
    }
    @Given("user has added a product to the cart")
    public void userHasAddedAProductToTheCart() {
        productsPage = new ProductsPage(Hooks.driver);
        productsPage.addProductToCart();
    }
    @Then("user opens the cart")
    public void userOpensTheCart() {
        productsPage.openCart();
    }
    @When("user proceeds to checkout")
    public void userProceedsToCheckout() {
        cartPage = new CartPage(Hooks.driver);
        cartPage.clickCheckout();
    }
    @When("user enters checkout details")
    public void userEntersCheckoutDetails() {
        checkoutPage = new CheckoutPage(Hooks.driver);
        checkoutPage.enterCheckoutDetails("Amit", "Kumar", "110020");
    }
    @When("user continues to checkout overview")
    public void userContinuesToCheckoutOverview() {
        checkoutPage.clickContinue();
    }
    @When("user finishes the checkout")
    public void userFinishesTheCheckout() {
        checkoutPage.clickFinish();
    }
    @Then("order should be completed successfully")
    public void orderShouldBeCompletedSuccessfully() {
        Assert.assertEquals(
                checkoutPage.getSuccessMessage(),
                "Thank you for your order!"
        );
    }
}