package com.zapkiller.automation.pages;

import com.zapkiller.automation.utils.UIAutomationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends UIAutomationUtils {

    public WebDriver driver;
    public By socialTitle = By.id("field-id_gender-1");
    public By firstName = By.id("field-firstname");
    public By lastName = By.id("field-lastname");
    public By email = By.id("field-email");
    public By password = By.id("field-password");
    public By birthDate = By.id("field-birthday");
    public By termsCheckbox = By.name("psgdpr");
    public By customerProvacyCheckbox = By.name("customer_privacy");

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    /**
     * <p>Registers new User</p>
     * @param socialTitle
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param birthDate
     */
    public void registerNewUser(String socialTitle,  String firstName, String lastName, String email, String password, String birthDate) {
        clickElement(this.socialTitle);
        typeIntoField(this.firstName, firstName);
        typeIntoField(this.lastName, lastName);
        typeIntoField(this.email, email);
        typeIntoField(this.password, password);
        typeIntoField(this.birthDate, birthDate);
        clickElement(termsCheckbox);
        clickElement(customerProvacyCheckbox);
    }
}
