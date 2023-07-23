package org.dailymail.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;

import org.dailymail.utils.DateUtils;
import org.dailymail.utils.FileIO;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class BaseUI {

    public static AndroidDriver driver;
    public static Properties prop;
    public static ExtentReports report;
    public static ExtentTest logger;
    public static String timestamp = DateUtils.getTimeStamp();
    public static String browser_choice;
    public BaseUI() {
        prop = FileIO.initProperties();
    }
    /************** Invoke Browser ****************/
    public static AndroidDriver invokeBrowser() {

        browser_choice = prop.getProperty("browserName");
        try {
            if (browser_choice.equalsIgnoreCase("firefox")) {
                driver = DriverSetup.getFirefoxDriver();
            } else if (browser_choice.equalsIgnoreCase("msedge")) {
                driver = DriverSetup.getMSEdgeDriver();
            } else if (browser_choice.equalsIgnoreCase("chrome")){
                driver = DriverSetup.getChromeDriver();
            } else{
                throw new Exception("Invalid browser name provided in property file");
            }

        } catch (Exception e) {
            reportFail(e.getMessage());
        }

        return driver;
    }

    /************** Open website URL ****************/
    public static void openBrowser(String websiteUrlKey) {
        try {
            driver.get(prop.getProperty(websiteUrlKey));
        } catch (Exception e) {
            e.printStackTrace();
            reportFail(e.getMessage());
        }
    }
    /************** Check if an element is present ****************/
    public static boolean isElementPresent(By locator, Duration timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /************** Send text to an element ****************/
    public static void sendText(By locator, String text) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
            driver.findElement(locator).sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
            reportFail(e.getMessage());
        }
    }
    /************** Get text of element ****************/
    public static String getText(By locator) {
        String text = null;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(locator));
            text = driver.findElement(locator).getText();
        } catch (Exception e) {
            e.printStackTrace();
            reportFail(e.getMessage());
        }
        return text;
    }
    /************** Click on element with WebElement ****************/
    public static void clickOn(By locator, Duration timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions
                    .elementToBeClickable(locator));
            driver.findElement(locator).click();
        } catch (Exception e) {
            e.printStackTrace();
            reportFail(e.getMessage());
        }
    }
    /************** Click on element with Actions ****************/
    public static void clickAction(By locator, Duration timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions
                    .elementToBeClickable(locator));
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(locator)).build().perform();
            action.click(driver.findElement(locator)).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
            reportFail(e.getMessage());
        }
    }
    /************** Click on element with JavaScript ****************/
    public static void clickJS(By locator, Duration timeout) {
        try {
            new WebDriverWait(driver, timeout).until(ExpectedConditions
                    .elementToBeClickable(locator));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].scrollIntoView();",
                    driver.findElement(locator));
            jse.executeScript("arguments[0].click();", driver.findElement(locator));
        } catch (Exception e) {
            e.printStackTrace();
            reportFail(e.getMessage());
        }
    }
    /**************** Get By locator using locator key ****************/
    public static By getLocator(String locatorKey) {
        if (locatorKey.endsWith("_id")) {
            return By.id(prop.getProperty(locatorKey));
        }
        if (locatorKey.endsWith("_name")) {
            return (By.name(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_className")) {
            return (By.className(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_xpath")) {
            return (By.xpath(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_css")) {
            return (By.cssSelector(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_linkText")) {
            return (By.linkText(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_partialLinkText")) {
            return (By.partialLinkText(prop.getProperty(locatorKey)));
        }
        if (locatorKey.endsWith("_tagName")) {
            return (By.tagName(prop.getProperty(locatorKey)));
        }

        reportFail("Failing test case, Invalid locator key: " + locatorKey);
        return null;
    }
    /************** Take screenshot ****************/
    public static void takeScreenShot(String filepath) {
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(filepath);
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /************** Report fail test ****************/
    public static void reportFail(String reportMessage) {

        Assert.fail("Test case failed: " + reportMessage);
    }
}
