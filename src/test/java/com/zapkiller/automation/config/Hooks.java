package com.zapkiller.automation.config;

import com.zapkiller.automation.utils.UIAutomationUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import java.util.Properties;

public class Hooks {
    public static final Logger logger = LoggerFactory.getLogger(Hooks.class);
    public static Properties configProps;
    public static ChromeOptions options = new ChromeOptions();
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite(){
        configProps = UIAutomationUtils.readConfig();
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class....");
    }

    @BeforeTest
    public void beforeTest(){
        launchBrowser();
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod...");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod....");
    }

    @AfterTest
    public void afterTest(){
        closeBrowser();
    }

    @AfterClass
    public void afterClass(){
        System.out.println("After Class....");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite");
    }



    /**
     * <p> This method is used to launch browser based on user choice</p>
     * @Version 1.0
     */
    public void launchBrowser(){
        if(configProps.getProperty("browser").equalsIgnoreCase("CHROME")){
            if(configProps.getProperty("browser.chrome.options.headless").equalsIgnoreCase("true")){
                options.addArguments("--headless");
            }
            driver = new ChromeDriver(options);
        }
    }

    /**
     * <p>Terminateds the webdriver session</p>
     * @Version 1.0
     */
    public void closeBrowser(){
        driver.close();
    }
}
