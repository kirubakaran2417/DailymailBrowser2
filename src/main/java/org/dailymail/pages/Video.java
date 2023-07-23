package org.dailymail.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.dailymail.base.BaseUI;
import org.openqa.selenium.By;

import java.time.Duration;

public class Video extends BaseUI {
    By play=getLocator("play_cssSelector");
    By pause=getLocator("pause_xpath");
    By search=getLocator("search_xpath");
    By searchText=getLocator("searchtext_xpath");
    By searchButton=getLocator("searchButton_xpath");
    By oldest=getLocator("oldest_xpath");
    public ExtentTest logger;
    public AndroidDriver driver;

    public Video(){}
    public Video(AndroidDriver driver){
        this.driver = driver;
    }
    public Video(ExtentTest logger, AndroidDriver driver) {
        this.driver = driver;
        this.logger = logger;
    }

    public void playButtonClick(){
        clickAction(play, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of play button is completed");

    }
    public void pauseButtonClick(){
        clickOn(pause, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of pause button is completed successfully");
    }
    public void searchClick(){
        clickOn(search, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of search button is completed successfully");
    }
    public void searchText(String data) {
            sendText(searchText, data);;
            logger.log(Status.INFO, "Entering search text is completed");
    }
    public void searchButton(){
        clickOn(searchButton, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of search button is completed successfully");
    }
    public void oldestButton(){
        clickOn(oldest, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of oldest button is completed successfully");
    }
}
