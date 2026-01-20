package org.Flipkart.ScreenShots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static org.Flipkart.DriverSetup.DriverSetup.driver;

public class screenShot {
 static int flag=1;
    // Method to take screenshot
    public static void captureScreenshot(WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(src, new File("C:\\Users\\2457401\\IdeaProjects\\Flipkart\\src\\main\\java\\org\\Flipkart\\ScreenShots\\Captures"+flag+".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        flag++;
    }
}

