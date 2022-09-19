package com.SuitCRM.tests.BenutzerImportieren;
import com.SuitCRM.pages.AccountsPage;
import com.SuitCRM.pages.DashboardPage;
import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import com.SuitCRM.utilities.ExcelUtil;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class SCEP_T26 extends TestBase {


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
        AccountsPage accountsPage= new AccountsPage();
        accountsPage.importButton.click();

        driver.findElement(By.id("userfile")).sendKeys("C:\\Users\\SelcukAyhan\\Desktop\\Accounts.csv");
        Thread.sleep(2000);

        driver.findElement(By.id("gonext")).click();


        WebElement pageName = driver.findElement(By.xpath("//h2[@class='module-title-text']"));
        String actual = pageName.getText();
        String expected = "STEP 2: CONFIRM IMPORT FILE PROPERTIES";
        Assert.assertEquals(actual,expected);


//span[@class='suitepicon suitepicon-action-import']

    /* public void test1(String username,String password,String firstName,String lastName){
        extentLogger=report.createTest("Test "+firstName+" "+lastName);
        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();;

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.waitUntilLoaderScreenDisappear();

        String actualFullName = dashboardPage.getUserName();
        String expectedFullName = firstName+" "+lastName;

        Assert.assertEquals(actualFullName,expectedFullName,"verify fullname");
        extentLogger.pass("PASSED");*/
    }

}
