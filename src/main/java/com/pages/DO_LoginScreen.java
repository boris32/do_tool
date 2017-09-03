package com.pages;

import com.util.AppConfig;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.URL;

/**
 * Created by Boris Sabados on 12/1/2016.
 */
public class DO_LoginScreen extends DO_BasePage {

    @FindBy(name = "do_user")
    protected WebElement login_username;

    @FindBy(name = "do_pass")
    protected WebElement login_pass;

    @FindBy(xpath = "//*[@id='login_form_id']/div/div/div[4]/div[2]/input")
    protected WebElement login_button;

    public void enterUsername (String value) {
        login_username.sendKeys(value);
    }

    public void enterPassword (String value) {
        login_pass.sendKeys(value);
    }
    public void clickOnLogin() {
        login_button.click();
    }

    public void logInAsDefaultUser ()
    {
        AppConfig apconfig = new AppConfig("C:\\Automation\\deleteThis\\local-app.properties");
        enterUsername(apconfig.readProperty("username"));
        enterPassword(apconfig.readProperty("password"));
        clickOnLogin();
    }


}
