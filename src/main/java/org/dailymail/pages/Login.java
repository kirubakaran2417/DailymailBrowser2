package org.dailymail.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.android.AndroidDriver;
import org.dailymail.base.BaseUI;
import org.openqa.selenium.By;

import java.time.Duration;

public class Login extends BaseUI {
    By username=getLocator("username_name");
    By password=getLocator("password_name");
    By clickLogin=getLocator("click_xpath");
    public ExtentTest logger;
    public AndroidDriver driver;

    public Login(){}
    public Login(AndroidDriver driver){
        this.driver = driver;
    }
    public Login(ExtentTest logger, AndroidDriver driver) {
        this.driver = driver;
        this.logger = logger;
    }
    public void usernametextbox(String data) {
        sendText(username, data);;
        logger.log(Status.INFO, "Entering username is completed");
    }
    public void passwordtextbox(String data) {
        sendText(password, data);;
        logger.log(Status.INFO, "Entering password is completed");
    }
    public void clickLogin(){
        clickOn(clickLogin, Duration.ofSeconds(10));
        logger.log(Status.INFO, "click submit is completed");
    }

}
