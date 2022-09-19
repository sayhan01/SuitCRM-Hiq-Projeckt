package com.SuitCRM.tests.NeuenAccountHerstellen;

import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SCEP_T7 extends TestBase {


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
        name.sendKeys("Toby Hoby");

        WebElement email = driver.findElement(By.id("Accounts0emailAddress0"));
        email.sendKeys("TobyHoby@gmail.com");
        WebElement postalCode = driver.findElement(By.id("billing_address_postalcode"));
        postalCode.sendKeys("77999");
        WebElement sippingPostalCode = driver.findElement(By.id("shipping_checkbox"));
        sippingPostalCode.click();
        WebElement assignedPeople = driver.findElement(By.id("assigned_user_name"));
        assignedPeople.clear();
        Thread.sleep(1000);

        assignedPeople.sendKeys("Anton Borc");

        Thread.sleep(1000);

        WebElement saveButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input[1]"));
        saveButton.click();

        WebElement actualAssign = driver.findElement(By.xpath("//div[@field='assigned_user_name']"));
        String expectedassign="";
        Assert.assertEquals(actualAssign.getText(), expectedassign);


        WebElement actionButton = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[4]/a"));
        actionButton.click();

        List<WebElement> dropDownOptions1 = driver.findElements(By.xpath("/html/body/div[3]/div/div/div[2]/ul/li[4]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions1.size());
        dropDownOptions1.get(2).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();


    }
}