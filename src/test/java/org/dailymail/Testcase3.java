package org.dailymail;

import io.appium.java_client.android.AndroidDriver;
import org.dailymail.base.BaseUI;
import org.dailymail.pages.Gallery;
import org.dailymail.pages.Homepage;
import org.dailymail.pages.Video;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase3 extends BaseUI {

    private AndroidDriver driver;
    @BeforeClass
    public void setUp(){
        driver = invokeBrowser();
        openBrowser("websiteURL");
    }
    @Test(priority = 0)
    public void clickplayButtonClick(){
        Video video = new Video(logger,driver);
        video.playButtonClick();
    }
    @Test(priority = 1)
    public void clickpauseButtonClick(){
        Video video = new Video(logger,driver);
        video.pauseButtonClick();
    }
    @Test(priority = 2)
    public void clicksearchButton(){
        Video video = new Video(logger,driver);
        video.searchButton();
    }
    @Test(priority = 3)
    public void TypeSearchText(){
        Video video = new Video(logger,driver);
        video.searchText("putin");
    }
    @Test(priority = 4)
    public void searchButton(){
        Video video = new Video(logger,driver);
        video.searchButton();
    }

    @Test(priority = 5)
    public void close(){
        Video video = new Video(logger,driver);
        video.oldestButton();
    }

}
