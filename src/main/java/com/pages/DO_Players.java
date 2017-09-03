package com.pages;

import com.util.AppConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Boris Sabados on 12/1/2016.
 */
public class DO_Players extends DO_BasePage {

    protected List<WebElement> all_players_rows;
    protected WebElement firstTeamLink;
    protected WebElement youthTeamLink;

    protected AppConfig apconfig = new AppConfig(".\\app.properties");

    protected DO_Navigation_Menu menu;

    public DO_Players(WebDriver driver) {

        this.driver = driver;

        menu = PageFactory.initElements(driver, DO_Navigation_Menu.class);
        menu.goToPlayers();
    }

    public void initializePageControls() {
        all_players_rows = driver.findElements(By.xpath("//tr[contains(@class,'matches_row')]"));
    }


    public void sendPlayerToYouthTeam(WebElement playerLink) {
        playerLink.click();

        Player_Details_Page pd = new Player_Details_Page(driver);
        pd.clickMoveToYouthButton();
        System.out.println("**Remaining players in First Team: " + (all_players_rows.size()-1));
        //pd.clickBackButton();
        //clickOnFirstTeamLink();
    }

    public void sendPlayerToFirstTeam(WebElement playerLink) {
        playerLink.click();

        Player_Details_Page pd = new Player_Details_Page(driver);
        pd.clickMoveToFirstButton();
        pd.clickBackButton();
        clickOnYouthTeamLink();
    }

    public void clickOnFirstTeamLink() {
        firstTeamLink = driver.findElement(By.xpath(".//*[@id='senior2']"));
            firstTeamLink.click();
    }

    public void clickOnYouthTeamLink() {
        youthTeamLink = driver.findElement(By.xpath(".//*[@id='youth2']"));
        youthTeamLink.click();
    }

    public boolean moveAllYoungstersToYouthTeam () {
        menu.goToPlayers();
        initializePageControls();

        int tdForLink1 = Integer.parseInt(apconfig.readProperty("first_column_index_in_player_linkt_table1"));
        int tdForLink2 = Integer.parseInt(apconfig.readProperty("first_column_index_in_player_link_table2"));
        int tdForAge1 = Integer.parseInt(apconfig.readProperty("first_column_index_player_age"));

        int tdForLink3 = Integer.parseInt(apconfig.readProperty("second_column_index_in_player_linkt_table1"));
        int tdForLink4 = Integer.parseInt(apconfig.readProperty("second_column_index_in_player_link_table2"));
        int tdForAge2 = Integer.parseInt(apconfig.readProperty("second_column_index_player_age"));

        if (all_players_rows.size() > 0) {
            for (int i = 0; i < all_players_rows.size(); i++) {

                WebElement playerLink;
                int age = 100;

                try {
                    playerLink = all_players_rows.get(i).findElements(By.tagName("td")).get(tdForLink1).findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElement(By.tagName(("tr"))).findElements(By.tagName("td")).get(tdForLink2).findElement(By.tagName("a"));
                    age = Integer.parseInt(all_players_rows.get(i).findElements(By.tagName("td")).get(tdForAge1).getText());
                }
                catch (Exception e) {
                    try {
                        playerLink = all_players_rows.get(i).findElements(By.tagName("td")).get(tdForLink3).findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElement(By.tagName(("tr"))).findElements(By.tagName("td")).get(tdForLink4).findElement(By.tagName("a"));
                        age = Integer.parseInt(all_players_rows.get(i).findElements(By.tagName("td")).get(tdForAge2).getText());
                    }
                    catch (Exception e1)
                    {
                        playerLink = null;
                    }
                }

                if (playerLink == null)
                    continue;

                if (playerLink.getText().contains("Loaned"))
                    continue;

                if (age < 19) {
                    sendPlayerToYouthTeam(playerLink);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean moveAllYoungstersToFirstTeam () {
        clickOnYouthTeamLink();
        initializePageControls();

        int tdForLink1 = Integer.parseInt(apconfig.readProperty("first_column_index_in_player_linkt_table1"));
        int tdForLink2 = Integer.parseInt(apconfig.readProperty("first_column_index_in_player_link_table2"));
        int tdForAge1 = Integer.parseInt(apconfig.readProperty("first_column_index_player_age"));

        int tdForLink3 = Integer.parseInt(apconfig.readProperty("second_column_index_in_player_linkt_table1"));
        int tdForLink4 = Integer.parseInt(apconfig.readProperty("second_column_index_in_player_link_table2"));
        int tdForAge2 = Integer.parseInt(apconfig.readProperty("second_column_index_player_age"));

        if (all_players_rows.size() > 0) {
            for (int i = 0; i < all_players_rows.size(); i++) {

                WebElement playerLink;
                int age = 100;

                try {
                    playerLink = all_players_rows.get(i).findElements(By.tagName("td")).get(tdForLink1).findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElement(By.tagName(("tr"))).findElements(By.tagName("td")).get(tdForLink2).findElement(By.tagName("a"));
                    age = Integer.parseInt(all_players_rows.get(i).findElements(By.tagName("td")).get(tdForAge1).getText());
                }
                catch (Exception e) {
                        try {
                            playerLink = all_players_rows.get(i).findElements(By.tagName("td")).get(tdForLink3).findElement(By.tagName("table")).findElement(By.tagName("tbody")).findElement(By.tagName(("tr"))).findElements(By.tagName("td")).get(tdForLink4).findElement(By.tagName("a"));
                            age = Integer.parseInt(all_players_rows.get(i).findElements(By.tagName("td")).get(tdForAge2).getText());
                        }
                        catch (Exception e1)
                        {
                            playerLink = null;
                        }
                }

                if (playerLink == null)
                    continue;

                if (playerLink.getText().contains("Loaned"))
                    continue;

                if (age < 19) {
                    sendPlayerToFirstTeam(playerLink);
                    return false;
                }
            }
        }
        return true;
    }
}