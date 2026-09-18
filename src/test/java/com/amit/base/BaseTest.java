package com.amit.base;

import com.amit.utils.ConfigReader;
import com.amit.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.amit.listeners.TestListener;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)

public class BaseTest {
    protected WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup(){

        String browser = ConfigReader.getProperty("browser");
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("baseUrl"));
    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
