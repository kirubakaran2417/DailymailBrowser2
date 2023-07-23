package org.dailymail.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.dailymail.base.BaseUI;
import org.openqa.selenium.By;

import java.time.Duration;

public class Homepage extends BaseUI {
    By classicHomepage=getLocator("classicHomepage_xpath");
    By login=getLocator("login_linkText");
    By comment=getLocator("comment_xpath");
    By commentText=getLocator("comment_name");
    By commentButton=getLocator("comment_id");
    public ExtentTest logger;
    public AndroidDriver driver;

    public Homepage(){}
    public Homepage(AndroidDriver driver){
        this.driver = driver;
    }
    public Homepage(ExtentTest logger, AndroidDriver driver) {
        this.driver = driver;
        this.logger = logger;
    }

     public void clickClassichomepage(){
        clickOn(classicHomepage, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of classic home page button is completed");
     }
     public void clickLogin(){
        clickOn(login, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of login is completed");
     }
     public void clickComment(){
        clickOn(comment, Duration.ofSeconds(10));
         logger.log(Status.INFO, "click of comment link is completed");

     }
    public void commentText(String data) {
        sendText(commentText, data);;
        logger.log(Status.INFO, "Entering comment text is completed");
    }
    public void commentButton(){
        clickOn(commentButton, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click of comment Button is completed");

    }
}
