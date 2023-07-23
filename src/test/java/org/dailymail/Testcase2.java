package org.dailymail;

import io.appium.java_client.android.AndroidDriver;
import org.dailymail.base.BaseUI;
import org.dailymail.pages.Gallery;
import org.dailymail.pages.Homepage;
import org.dailymail.pages.Login;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase2 extends BaseUI {

    private AndroidDriver driver;
    @BeforeClass
    public void setUp(){
        driver = invokeBrowser();
        openBrowser("websiteURL");
    }
    @Test(priority = 0)
    public void clickonclassichomepage(){
        Homepage homepage = new Homepage(logger,driver);
        homepage.clickClassichomepage();
    }

    @Test(priority = 1)
    public void clickgalleryImage(){
        Gallery gallery = new Gallery(logger,driver);
       gallery.setGalleryImage();
    }
    @Test(priority = 2)
    public void clickGalleryicon(){
        Gallery gallery = new Gallery(logger,driver);
        gallery.clickGalleryicon();
    }
    @Test(priority = 3)
    public void carosel_(){
        Gallery gallery = new Gallery(logger,driver);
        gallery.carosel();
    }

    @Test(priority = 4)
    public void close(){
        Gallery gallery = new Gallery(logger,driver);
        gallery.close();
    }

}
