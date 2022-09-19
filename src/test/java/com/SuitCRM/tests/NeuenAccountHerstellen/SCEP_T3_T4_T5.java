package com.SuitCRM.tests.NeuenAccountHerstellen;

import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SCEP_T3_T4_T5 extends TestBase {


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
        Thread.sleep(2000);

        assignedPeople.sendKeys("Markus Sajonz");
        WebElement assignedPeople1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[2]/div[3]/div[2]/div[2]/div/div/div[17]/div[2]/div/div/div[2]/ul/li[1]"));
        assignedPeople1.click();
        Thread.sleep(2000);
        WebElement saveButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/form/div[3]/input[1]"));
        saveButton.click();

        WebElement tableName = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/h2"));
        System.out.println(tableName.getText());
        String expected = "TOBY HOBY";
        Assert.assertEquals(tableName.getText(), expected);
        WebElement actualEmail = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[3]/div[1]/div[3]/div/div[2]/span/table/tbody/tr/td/b/a"));
        String expectedEmail="TobyHoby@gmail.com";
        Assert.assertEquals(actualEmail.getText(), expectedEmail);
        WebElement actualassiegn = driver.findElement(By.id("assigned_user_id"));
        String expectedassign="Markus Sajonz";
        Assert.assertEquals(actualassiegn.getText(), expectedassign);


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