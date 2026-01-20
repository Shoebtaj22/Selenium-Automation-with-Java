package org.Flipkart.PageLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class Locators {
    static WebDriver driver;
    static WebElement element;
    static List<WebElement> elementList;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static WebElement SearchBox(WebDriver driver) {
        //Locating SearchBox
        element = driver.findElement(By.className("lNPl8b"));
        return element;
    }

    public static WebElement processorgeneration(WebDriver driver) {
        //Locating Processor Type Dropdown
        element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div/div[1]/div/section[6]/div[1]/div"));
        // element=driver.findElement(By.xpath("(//div[contains(.,'Processor Generation')])[9]"));
        return element;
    }

    public static WebElement processortype(WebDriver driver) {
        //Selecting the checkbox
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='buvtMR' and contains(.,'14')]")));
        return element;
    }

    public static WebElement operatingsystem(WebDriver driver) {
        //Locating the Opearting System Dropdown
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div)[32]")));
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Operating System']")));
        return element;
    }

    public static WebElement operatingsystemtype(WebDriver driver) {
        //Selecting the checkbox
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[normalize-space()='Windows 11']")));
        return element;
    }

    public static WebElement slider(WebDriver driver) throws InterruptedException {
        //Locating Slider
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div)[32]")));
        element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='G12X4V'])[2]")));
        Actions act = new Actions(driver);
        act.dragAndDropBy(element, -100, 0).perform();
        return element;
    }

    public static void waituntil(WebDriver driver) {
        //Waiting for all elements to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait until the 32nd div is visible
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div)[32]")));
    }

    public static List<WebElement> resultslist(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        List<WebElement> elementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("DeU9vF")));
        return elementList;
    }

}
