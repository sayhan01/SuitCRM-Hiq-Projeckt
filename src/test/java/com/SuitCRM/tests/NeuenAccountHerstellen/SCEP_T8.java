package com.SuitCRM.tests.NeuenAccountHerstellen;

import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.SuitCRM.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SCEP_T8 extends TestBase {


    @Test

    public void test1() throws InterruptedException {
        extentLogger = report.createTest("test1");
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Thread.sleep(1000);

        WebElement dropdownElement = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[5]/ul/li[1]/a"));
        dropdownElement.click();
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("/html/body/div[2]/nav/div/div[5]/ul/li[1]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        dropDownOptions.get(0).click();

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Toby Hoby");
        WebElement postalCode = driver.findElement(By.id("billing_address_postalcode"));
        postalCode.sendKeys("selcu");
        WebElement sippingPostalCode = driver.findElement(By.id("shipping_checkbox"));
        sippingPostalCode.click();

        WebElement fehler= driver.findElement(By.xpath("//div [@class='required validation-message']"));
        Assert.assertTrue(fehler.isDisplayed());




    }
}
