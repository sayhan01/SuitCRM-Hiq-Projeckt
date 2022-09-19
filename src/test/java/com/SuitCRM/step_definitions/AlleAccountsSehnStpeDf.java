package com.SuitCRM.step_definitions;

import com.SuitCRM.pages.AccountsPage;
import com.SuitCRM.pages.DashboardPage;
import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import com.SuitCRM.utilities.BrowserUtils;
import com.SuitCRM.utilities.ConfigurationReader;
import com.SuitCRM.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import java.util.List;

public class AlleAccountsSehnStpeDf  {
    AccountsPage accountsPage= new AccountsPage();
    DashboardPage dashboardPage= new DashboardPage();

    @Given("User ist in SuiteCRM ingeloggt und befindet sich auf der Homepage")
    public void user_ist_in_SuiteCRM_ingeloggt_und_befindet_sich_auf_der_Homepage() {
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("SuiteCRM", actualTitle);
    }



    @When("Gehe auf Sales-Menu-Dropdown und wahle Accounts")
    public void Gehe_auf_SalesMenu_Dropdown_und_wahle_Accounts() throws InterruptedException {

        dashboardPage.salesDropDown.click();

        List<WebElement> dropDownOptions =Driver.get().findElements(By.xpath("//*[@id=\"toolbar\"]/ul/li[2]/span[2]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        dropDownOptions.get(1).click();
        Thread.sleep(1000);

    }
    @When("User klickt auf Edit button fur eine vorhandane Account")
    public void user_klickt_auf_Edit_button_fur_eine_vorhandane_Account() throws InterruptedException {
        Thread.sleep(3000);
        accountsPage.editButton.click();

    }
    @When("Beutzer andert gewunschte Daten")
    public void beutzer_andert_gewunschte_Daten() throws InterruptedException {
        accountsPage.city.clear();
        Thread.sleep(3000);
        accountsPage.city.sendKeys("Lahr");

        Thread.sleep(1000);
    }
    @When("User klickt auf den Save Button")
    public void user_klickt_auf_den_Save_Button() {
        accountsPage.saveButton.click();
    }
    @Then("Vorhandene Account wurde mit neue Daten angelegt")
    public void vorhandene_Account_wurde_mit_neue_Daten_angelegt() {
        WebElement actual = Driver.get().findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[3]/div[1]/div[4]/div[1]/div[2]/table/tbody/tr/td[1]"));
        String expectedCity = "Lahr   selcu";


       Assert.assertEquals(expectedCity,actual.getText());
    }






    @When("User klickt auf Suchen Tab in der Navigationsleiste")
    public void user_klickt_auf_Suchen_Tab_in_der_Navigationsleiste() {
        dashboardPage.searchButton.click();
    }

    @When("User fullt eine vorhandene Accountname Feld Search aus")
    public void user_fullt_eine_vorhandene_Accountname_Feld_Search_aus() {
        dashboardPage.searchTab.sendKeys("Thomas Schnieder");
    }

    @When("User klickt Search Button oder enter")
    public void user_klickt_Search_Button_oder_enter() {
        dashboardPage.searchButton2.click();
    }

    @Then("User findet vorhandene Account")
    public void user_findet_vorhandene_Account() {
        WebElement accounts = Driver.get().findElement(By.xpath("//table[@class='list View']/tbody[2]/tr[1]/td[2]"));
        String actual=accounts.getText();

        String expected = "Thomas Schnieder";

        Assert.assertEquals(expected,actual);
    }



}
