package com.SuitCRM.tests.BenutzerImportieren;

import com.SuitCRM.pages.AccountsPage;
import com.SuitCRM.pages.DashboardPage;
import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SCEP_T27 extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Thread.sleep(2000);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.salesDropDown.click();

        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//*[@id=\"toolbar\"]/ul/li[2]/span[2]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        dropDownOptions.get(1).click();
        AccountsPage accountsPage = new AccountsPage();
        accountsPage.importButton.click();

        driver.findElement(By.id("userfile")).sendKeys("C:\\Users\\SelcukAyhan\\Desktop\\Accounts.csv");
        Thread.sleep(2000);

        driver.findElement(By.id("gonext")).click();
        driver.findElement(By.id("gonext")).click();
        List<WebElement> dropDownOptions1 = driver.findElements(By.xpath("//td[@id='row_0_col_0']/select/option"));
        System.out.println("dropDownOptions1.size() = " + dropDownOptions.size());
        dropDownOptions1.get(34).click();
        Thread.sleep(2000);
        List<WebElement> dropDownOptions2 = driver.findElements(By.xpath("//td[@id='row_1_col_0']/select/option"));
        System.out.println("dropDownOptions1.size() = " + dropDownOptions.size());
        dropDownOptions2.get(7).click();
        List<WebElement> dropDownOptions3 = driver.findElements(By.xpath("//td[@id='row_2_col_0']/select/option"));
        System.out.println("dropDownOptions1.size() = " + dropDownOptions.size());
        dropDownOptions3.get(43).click();

        driver.findElement(By.id("gonext")).click();
        driver.findElement(By.id("importnow")).click();



        WebElement createdMessage = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div/span"));
        String actual = createdMessage.getText();
        String expected = "1 records were created";
        Assert.assertEquals(actual, expected);
        Thread.sleep(1000);
        driver.findElement(By.id("undo")).click();
        Thread.sleep(1000);
    }
}