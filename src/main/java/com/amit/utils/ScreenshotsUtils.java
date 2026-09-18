package com.amit.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotsUtils {

    public static void takeScreenshot(WebDriver driver, String screenshotName) {

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File destination = new File("screenshots/" + screenshotName + ".png");

        try {Files.createDirectories(destination.getParentFile().toPath());

            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {throw new RuntimeException(e);
        }
    }
}