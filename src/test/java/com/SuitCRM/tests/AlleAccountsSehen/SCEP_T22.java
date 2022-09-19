package com.SuitCRM.tests.AlleAccountsSehen;
import com.SuitCRM.pages.AccountsPage;
import com.SuitCRM.pages.DashboardPage;
import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SCEP_T22 extends TestBase {

    @Test

    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Thread.sleep(1000);

        DashboardPage dashboardPage= new DashboardPage();

        //WebElement dropdownElement = driver.findElement(By.id("grouptab_0"));
        dashboardPage.salesDropDown.click();

        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//*[@id=\"toolbar\"]/ul/li[2]/span[2]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        dropDownOptions.get(1).click();

        AccountsPage accountsPage=new AccountsPage();
        accountsPage.createButton2.click();
        Thread.sleep(1000);

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Toby Hoby");
        WebElement postalCode = driver.findElement(By.id("billing_address_postalcode"));
        postalCode.sendKeys("77999");
        WebElement sippingPostalCode = driver.findElement(By.id("shipping_checkbox"));
        sippingPostalCode.click();
        WebElement saveButton = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[3]/input[1]"));
        saveButton.click();
        WebElement actionButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[4]/a"));
        actionButton.click();

        List<WebElement> dropDownOptions1 = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[4]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions1.size());
        dropDownOptions1.get(2).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        System.out.println(accountsPage.tableName.getText());
        String expected= " ACCOUNTS";
        Assert.assertEquals(accountsPage.tableName.getText(),expected);
    }
}