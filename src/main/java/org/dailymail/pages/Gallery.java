package org.dailymail.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.dailymail.base.BaseUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class Gallery extends BaseUI {
    By classicHomepage=getLocator("classicHomepage_linkText");
    By imageGallery=getLocator("imageGallery_xpath");
    By galleryImage=getLocator("galleryImage_xpath");
    By galleryicon=getLocator("galleryIcon_css");
    By getcount=getLocator("imagecount_css");
    By clicknext=getLocator("clicknext_css");
    By close=getLocator("close_css");
    public ExtentTest logger;
    public AndroidDriver driver;

    public Gallery(){}
    public Gallery(AndroidDriver driver){
        this.driver = driver;
    }
    public Gallery(ExtentTest logger, AndroidDriver driver) {
        this.driver = driver;
        this.logger = logger;
    }

    public void clickClassichomepage(){
        clickOn(classicHomepage, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of classic home page button is completed");
    }


    public void setGalleryImage() {
        clickOn(galleryImage, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click on image is completed");
    }
    public void clickGalleryicon() {
        clickOn(galleryicon, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click on gallery icon is completed");
    }

    public void carosel() {
        String text = getText(getcount);
        int count=Integer.parseInt(text.split(" ")[2]);
        WebElement clickable=driver.findElement(clicknext);
        for (int i = 0; i < count; i++) {
            clickable.click();
        }
        logger.log(Status.INFO, "carosel is completed");
    }
    public void close(){
        clickOn(close, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click on close is completed");
    }
}
