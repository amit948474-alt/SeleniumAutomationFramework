package com.amit.pages;

import com.amit.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver driver;

    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartButton = By.className("shopping_cart_link");
    private By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }
    public void addProductToCart(){
        driver.findElement(addToCartButton).click();
    }
    public void openCart(){
        driver.findElement(cartButton).click();
    }
    public int getCartCount(){
        String count = driver.findElement(cartBadge).getText();
        return Integer.parseInt(count);
    }
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public void logout() {
        driver.findElement(menuButton).click();
        WaitUtils.waitForElementClickable(driver, logoutButton, 10).click();
    }
}
