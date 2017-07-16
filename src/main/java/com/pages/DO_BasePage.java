package com.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Boris Sabados on 11/28/2016.
 */
public class DO_BasePage {

    protected WebDriver driver;
    static private String configFilePath= "C:\\Automation\\deleteThis\\app.properties";


    public DO_BasePage() {
    }

    public static String getPropertiesFilePath () {
        return configFilePath;
    }

    public DO_BasePage(WebDriver webdriver) {
        this.driver = webdriver;
    }

}
