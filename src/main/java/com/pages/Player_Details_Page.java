package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Boris Sabados on 12/13/2016.
 */
public class Player_Details_Page extends DO_BasePage {

    WebElement btn_moveToYouth;
    WebElement btn_moveToFirst;
    WebElement btn_Back;

    DO_Navigation_Menu menu;

    public Player_Details_Page (WebDriver d) {
        this.driver = d;
    }

    public void clickMoveToYouthButton() {
        btn_moveToYouth = driver.findElement(By.xpath("//input[@value='Move to youth']"));
        if (btn_moveToYouth != null && btn_moveToYouth.getAttribute("value").equals("Move to youth"))
            btn_moveToYouth.click();
    }

    public void clickMoveToFirstButton() {
        btn_moveToFirst = driver.findElement(By.xpath("//input[@value='Move to 1st']"));
        if (btn_moveToFirst != null && btn_moveToFirst.getAttribute("value").equals("Move to 1st"))
            btn_moveToFirst.click();
    }

    public void clickBackButton() {
        btn_Back = driver.findElement(By.xpath("//input[@value='Back']"));
        if (btn_Back != null && btn_Back.getAttribute("value").equals("Back"))
            btn_Back.click();

    }

}
