package com.seleniumtester.driver;

import com.util.AppConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.pages.*;

import java.io.File;

import static java.awt.SystemColor.menu;

/**
 * Created by Boris Sabados on 11/25/2016.
 */
public class MyFirstSeleniumTest extends BaseTest {
    WebDriver driver = new ChromeDriver();

    @Test (priority = 0)
        public void initialTest () {
        String testId = "1.0";
        String testName = "Verify that page title is correct";


        AppConfig c = new AppConfig(DO_BasePage.getPropertiesFilePath());
        driver.get(c.readProperty("dugouturl"));

        DO_LoginScreen loginPage = PageFactory.initElements(driver, DO_LoginScreen.class);
        loginPage.logInAsDefaultUser();

        DO_Players playersPage = new DO_Players(driver);

        while (!playersPage.moveAllYoungstersToYouthTeam());
        while (!playersPage.moveAllYoungstersToFirstTeam());
    }

}