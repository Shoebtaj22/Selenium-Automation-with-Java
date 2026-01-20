package org.Flipkart.Home;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.Flipkart.DriverSetup.DriverSetup;
import org.Flipkart.Excel.Excelvals;
import org.Flipkart.PageLocators.Locators;
import org.Flipkart.ScreenShots.screenShot;
import org.Flipkart.Validation.validation;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Home {
    public static void main(String[] args) throws InterruptedException, IOException {

        // Setup Extent Report
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/FlipkartTestReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        //Create a test case entry
        ExtentTest test = extent.createTest("Flipkart Price Validation Test");

        WebDriver driver = DriverSetup.getWebDriver("chrome");
        test.info("Browser launched successfully");

        try {
            Locators.SearchBox(driver).sendKeys(Excelvals.getData() + Keys.ENTER);
            test.pass("Search executed successfully");

            Locators.processorgeneration(driver).click();
            test.pass("Processor generation filter applied");

            Locators.processortype(driver).click();
            test.pass("Processor type filter applied");

            Locators.operatingsystem(driver).click();
            Locators.operatingsystemtype(driver).click();
            test.pass("Operating system filter applied");

            Thread.sleep(2000);
            Locators.slider(driver);
            test.pass("Price slider adjusted");

            Thread.sleep(2000);
            System.out.println("Laptop prices under the range are");
            List<WebElement> results = Locators.resultslist(driver);
            System.out.println("The size of the Price List is:" +results.size());
            Boolean result = validation.areAllPricesUnderLimit(50000, driver);

            if (result) {
                test.pass(" All prices are under the price range");
            } else {
                test.fail(" At least one price is above the price range");
            }

            screenShot.captureScreenshot(driver);
            test.pass("Captured Screenshot");

        } catch (Exception e) {
            test.fail("Test failed due to exception: " + e.getMessage());
        } finally {
            //driver.quit();
            test.info("Browser closed");
            extent.flush(); // Write everything to the report
        }
    }
}
