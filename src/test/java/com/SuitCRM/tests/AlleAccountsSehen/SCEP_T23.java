package com.SuitCRM.tests.AlleAccountsSehen;
import com.SuitCRM.pages.AccountsPage;
import com.SuitCRM.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.SuitCRM.pages.LoginPage;
import com.SuitCRM.pages.DashboardPage;
import java.util.List;

public class SCEP_T23 extends TestBase {


    @Test

    public void test1() throws InterruptedException {
        AccountsPage accountsPage = new AccountsPage();
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Thread.sleep(2000);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.salesDropDown.click();

        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//*[@id=\"toolbar\"]/ul/li[2]/span[2]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        dropDownOptions.get(1).click();

        //WebElement vorhandeneAccount = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[3]/td[3]"));
        //vorhandeneAccount.click();
        WebElement phone = driver.findElement(By.xpath("/html/body/div[5]/div/div[3]/form[2]/div[3]/table/tbody/tr[3]/td[6]/div"));
        phone.click();


        System.out.println(accountsPage.tableName.getText());
        String expected= " ACCOUNTS";
        Assert.assertEquals(accountsPage.tableName.getText(),expected);
    }
}