package com.seleniumtester.driver;

import com.pages.DO_LoginScreen;
import com.pages.DO_Players;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * Created by Boris Sabados on 12/13/2016.
 */
public class MovePlayersToYouth extends BaseTest  {
    WebDriver driver = new ChromeDriver();

    @Test(priority = 0)
    public void initialTest () {
        driver.get("http://www.dugout-online.com/");

        DO_LoginScreen loginPage = PageFactory.initElements(driver, DO_LoginScreen.class);
        loginPage.logInAsDefaultUser();

        DO_Players playersPage = new DO_Players(driver);

        while (!playersPage.moveAllYoungstersToYouthTeam());
    }
}
