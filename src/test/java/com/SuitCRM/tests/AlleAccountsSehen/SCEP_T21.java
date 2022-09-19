package com.SuitCRM.tests.AlleAccountsSehen;

import com.SuitCRM.pages.DashboardPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SuitCRM.pages.LoginPage;




public class SCEP_T21 extends TestBase {

    @Test

    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Thread.sleep(2000);


        DashboardPage dashboardPage= new DashboardPage();
        dashboardPage.searchButton.click();
        dashboardPage.searchTab.sendKeys("Thomas Schnieder");
        dashboardPage.searchButton2.click();
        Thread.sleep(2000);
        WebElement accounts = driver.findElement(By.xpath("//table[@class='list View']/tbody[2]/tr[1]/td[2]"));
        String actual=accounts.getText();

        String expected = "Thomas Schnieder";

        Assert.assertEquals(actual,expected);


    }
}