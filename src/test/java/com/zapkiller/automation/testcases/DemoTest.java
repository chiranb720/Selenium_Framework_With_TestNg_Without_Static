package com.zapkiller.automation.testcases;

import com.zapkiller.automation.config.Hooks;
import com.zapkiller.automation.pages.HomePage;
import com.zapkiller.automation.pages.RegistrationPage;
import org.testng.annotations.Test;

public class DemoTest extends Hooks {

    public HomePage homePage;
    public RegistrationPage registerPage;

    @Test
    public void register_new_user_test() {
        homePage = new HomePage(driver);
        registerPage = new RegistrationPage(driver);

//        homePage.startRegistrationProcess();
//        registerPage.registerNewUser();

    }

}
