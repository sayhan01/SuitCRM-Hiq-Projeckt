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

public class SCEP_T10 extends TestBase{


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

        Thread.sleep(1000);
        accountsPage.editButton.click();
        Thread.sleep(1000);
        accountsPage.city.clear();
        Thread.sleep(1000);
        accountsPage.city.sendKeys("Lahr");

        Thread.sleep(1000);

        accountsPage.saveButton.click();

        WebElement actual = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div[3]/div[1]/div[4]/div[1]/div[2]/table/tbody/tr/td[1]"));
        String expectedCity = "Lahr   selcu";


        Assert.assertEquals(actual.getText(),expectedCity);

    }

}

/*       WebElement dropdownElement = driver.findElement(By.id("grouptab_0"));
        dropdownElement.click();

        List<WebElement> dropDownOptions = driver.findElements(By.xpath("//*[@id=\"toolbar\"]/ul/li[2]/span[2]/ul/li"));
        System.out.println("dropDownOptions.size() = " + dropDownOptions.size());
        dropDownOptions.get(1).click();

        Thread.sleep(1000);
        WebElement accountName = driver.findElement(By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr[2]/td[2]"));
        accountName.click();*/