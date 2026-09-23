package com.amit.stepdefinitions;

import com.amit.utils.ConfigReader;
import com.amit.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        String browser = ConfigReader.getProperty("browser");

        driver = DriverFactory.createDriver(browser);
        //driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}