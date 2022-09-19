package com.SuitCRM.tests.NeuenAccountHerstellen;

import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SCEP_T6 extends TestBase {


    @Test

    public void test1() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Thread.sleep(1000);

        WebElement dropdownElement = driver.findElement(By.xpath("/html/body/div[2]/nav/div/div[5]/ul/li[1]/a"));
        dropdownElement.click();
        List<WebElement> dropDownOptions = driver.findElements(By.xpath("/html/body/div[2]/nav/div/div[5]/ul/li[1]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        dropDownOptions.get(0).click();

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Thomas Schnieder");

        Thread.sleep(2000);
        WebElement saveButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input[1]"));
        saveButton.click();
        WebElement actualmessage = driver.findElement(By.xpath("(//div[@class='required validation-message'])[1]"));
        Assert.assertTrue(actualmessage.isDisplayed());

    }
}