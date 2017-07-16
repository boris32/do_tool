package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Boris Sabados on 11/28/2016.
 */
public class DO_Navigation_Menu extends DO_BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='comp_button_c']/a")
    protected WebElement competetionsLink;

    @FindBy (xpath = "//*[@id='mainmenu_container']/div[2]/div[2]/a")
    protected WebElement clubLink;

    @FindBy(xpath = "//*[@id='cls_subbutton_c']/a")
    protected  WebElement playersLink;

    public DO_Navigation_Menu (WebDriver webdriver) {
        this.driver=webdriver;
    }

    public void goToCompetetions () {
        competetionsLink.click();
    }

    public void goToClub() {
        clubLink.click();
    }

    public void goToPlayers() {
        clubLink.click();
        playersLink.click();
    }




}
