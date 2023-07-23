package org.dailymail.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverSetup {
    private static AndroidDriver driver;

    /********* Invoke Chrome Driver **********/
    public static AndroidDriver getChromeDriver() throws MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("kirubaphone");
//        options.setCapability("app", "Chrome");
        options.setCapability("chromedriverExecutable", "C:\\Users\\k.kirubakaran\\Downloads\\chromedriver_win32 (11)\\chromedriver.exe");
        options.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
        ChromeOptions options2 = new ChromeOptions();
        options2.addArguments("--disable-notifications");
        options2.addArguments("--remote-allow-origins=*");
        options.setCapability(ChromeOptions.CAPABILITY, options2);
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    /********* Invoke MSEdge Driver **********/
    public static AndroidDriver getMSEdgeDriver() {
      return null;
    }

    public static AndroidDriver getFirefoxDriver() {
        return null;
    }
}
