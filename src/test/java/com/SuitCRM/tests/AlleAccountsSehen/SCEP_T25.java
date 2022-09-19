package com.SuitCRM.tests.AlleAccountsSehen;
import com.SuitCRM.pages.AccountsPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.pages.DashboardPage;
import java.util.List;

public class SCEP_T25 extends TestBase {


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

        WebElement remove = driver.findElement(By.xpath("//input[@name='Remove']"));
        remove.click();

        String expected = "Are you sure you want to delete the 0 selected record(s)?";

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        System.out.println(alert.getText());
        Assert.assertEquals(alert.getText(),expected);

        alert.accept();




    }
}