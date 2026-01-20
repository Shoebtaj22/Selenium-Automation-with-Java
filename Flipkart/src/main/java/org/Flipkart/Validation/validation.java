package org.Flipkart.Validation;

import org.Flipkart.DriverSetup.DriverSetup;
import org.Flipkart.PageLocators.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class validation {

    WebDriver driver;

    // Constructor to initialize driver
    public validation() {
        this.driver = DriverSetup.getWebDriver("chrome");
    }

    // Method to validate prices under a given limit
    public static boolean areAllPricesUnderLimit(int limit, WebDriver driver) {
        List<WebElement> pricelist = Locators.resultslist(driver);// fetch fresh list

        for (WebElement i : pricelist) {
            try {
                String price = i.getText();
                System.out.println(price);
                int value = Integer.parseInt(price.replace("₹", "").replace(",", "").trim());

                if (value > limit) {
                    return false;
                }
            } catch (StaleElementReferenceException e) {
                // re-fetch element if stale
                return areAllPricesUnderLimit(limit, driver);
            }
        }
        return true;
    }



}
