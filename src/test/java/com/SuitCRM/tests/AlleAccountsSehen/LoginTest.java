package com.SuitCRM.tests.AlleAccountsSehen;

import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.SuitCRM.utilities.ConfigurationReader;
import com.SuitCRM.pages.LoginPage;

public class LoginTest extends TestBase {

    @Test
    public void OpenBrowserWithConf(){

        driver.get(ConfigurationReader.get("url"));

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("username_password")).sendKeys(password);
        driver.findElement(By.id("bigbutton")).click();
        LoginPage loginPage = new LoginPage();

    }
    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();

        loginPage.loginAsDriver();





    }
}