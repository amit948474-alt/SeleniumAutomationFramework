package com.amit.tests;

import com.amit.base.BaseTest;
import com.amit.listeners.RetryAnalyzer;
import com.amit.pages.LoginPage;
import com.amit.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }
}