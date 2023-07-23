package org.dailymail;

import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import org.dailymail.base.BaseUI;
import org.dailymail.pages.Homepage;
import org.dailymail.pages.Login;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase1 extends BaseUI {

    private AndroidDriver driver;
    @BeforeClass
    public void setUp(){
        driver = invokeBrowser();
        openBrowser("websiteURL");
    }
    @
    @Test(priority = 0)
    public void clickonclassichomepage(){
        Homepage homepage = new Homepage(logger,driver);
        homepage.clickClassichomepage();
    }
    @Test(priority = 1)
    public void clickLogin(){
        Homepage homepage = new Homepage(logger,driver);
        homepage.clickLogin();
    }
    @Test(priority = 2)
    public void setUsername(){
        Login login = new Login(logger,driver);
        login.usernametextbox("");
    }
    @Test(priority = 3)
    public void setPassword(){
        Login login = new Login(logger,driver);
        login.passwordtextbox("");
    }
    @Test(priority = 4)
    public void clickLogin_(){
        Login login = new Login(logger,driver);
        login.clickLogin();
    }
    @Test(priority = 5)
    public void clickComments(){
        Homepage homepage = new Homepage(logger,driver);
        homepage.clickComment();
    }
    @Test(priority = 6)
    public void setCommentText(){
        Homepage homepage = new Homepage(logger,driver);
        homepage.commentText("first text");
    }
    @Test(priority = 7)
    public void clickCommentButton(){
        Homepage homepage = new Homepage(logger,driver);
        homepage.commentButton();
    }
}
