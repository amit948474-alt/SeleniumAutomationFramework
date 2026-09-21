package com.amit.stepdefinitions;

import com.amit.pages.LoginPage;
import com.amit.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user is on the SauceDemo login page")
    public void userIsOnLoginPage() {
        loginPage = new LoginPage(Hooks.driver);
    }
    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }
    @When("user clicks the login button")
    public void userClicksLoginButton() {
        loginPage.clickLogin();
    }
    @Then("user should be redirected to the products page")
    public void userShouldBeRedirectedToProductsPage() {
        Assert.assertTrue(
                Hooks.driver.getCurrentUrl().contains("inventory")
        );
    }
}