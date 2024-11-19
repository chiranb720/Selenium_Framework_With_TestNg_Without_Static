package com.zapkiller.automation.pages;

import com.zapkiller.automation.utils.UIAutomationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends UIAutomationUtils {

    public By signInLink = By.xpath("//span[text()='Sign in']");
    public By registerLink = By.xpath("//a[contains(text(), 'No account? Create one here')]");
    public WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    /**
     * <p>Starts registration process</p>
     * @param url
     */
    public void startRegistrationProcess(String url) {
        navigateToUrl(url);
        clickElement(signInLink);
        clickElement(registerLink);
    }



}
